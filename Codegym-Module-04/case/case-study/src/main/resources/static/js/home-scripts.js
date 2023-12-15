var LoggedUser;
const linkAllProduct = "http://localhost:8080/api/product/all"
const linkPageProduct = "http://localhost:8080/api/product/allpage/";
var products;
var currentPage = 0;
var itemsPerPage = 8;
var totalPages;
$(window).on("load", function () {
    checkIsTokenValid();
})



$(document).ready(function () {
    fetchItemFromApi(currentPage);
    getItemsToModalsAndAddToCart();
    validateEmailSignUp();
    validatePasswordSignUp();

    $("#signInBtn").click(function (event) {
        event.preventDefault();
        loginAndFetchTokens();
    });
    $("#signUpBtn").click(function (event) {
        event.preventDefault();
        signUp();
    })
    $("#logout-btn").click(function () {
        logout();
    })
    $('#prevPageBtn').click(() => {
        if (currentPage > 0) {
            $(`#listProduct`).empty();
            currentPage--;
            fetchItemFromApi(currentPage);
        }
    })
    $('#nextPageBtn').click(() => {
        if (currentPage < totalPages - 1) {
            $(`#listProduct`).empty();
            currentPage++;
            fetchItemFromApi(currentPage);
        }
    })
})

function checkIsTokenValid() {
    const accessToken = localStorage.getItem("accessToken");
    if (accessToken === "undefined" || accessToken == null) {
        localStorage.removeItem("accessToken");
    } else {
        $.ajax({
            url: "http://localhost:8080/api/auth/refresh-token",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: accessToken,
            success: (authResponse) => {
                console.log(authResponse)
                localStorage.setItem("accessToken", authResponse.accessToken);
                Toast.fire({
                    icon: 'success',
                    title: `Signed in successfully, welcome back ${authResponse.email}`,
                    timer: 1600
                });
                displayUserAccount();
            },
            error: () => {
                Toast.fire({
                    icon: 'error',
                    title: `Too bad...Look like you have to sign in again :D`,
                    timer: 1600
                });
            }
        })
    }
}

function signUp() {
    let signUpUser = {
        email: $('#email-signup').val(),
        password: $('#password-signup').val()
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(signUpUser),
        url: "/api/auth/register",
        success: function () {
            Toast.fire({
                icon: 'success',
                title: `Sign-up successfully, welcome to our page, ${signUpUser.email}`,
                timer: 2000
            });
        },
        error: function (xhr) {
            Toast.fire({
                icon: 'error',
                title: `Look like something wrong`,
                timer: 2000
            });
            let errorMessage = xhr.responseText;
            $("#isInvalid").text(errorMessage);
        }
    })
}

function validateEmailSignUp() {
    $("#email-signup").on("input", function () {
            let emailInput = $(this);
            let emailPattern = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
            if (emailPattern.test(emailInput.val())) {
                emailInput.removeClass("is-invalid").addClass("is-valid");
            } else {
                emailInput.removeClass("is-valid").addClass("is-invalid");
            }
        }
    )
}

function validatePasswordSignUp() {
    $("#password-signup").on("input", function () {
        let passwordInput = $(this);
        let passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@.#$%^&+=!])[A-Za-z\d@.#$%^&+=!]{8,16}$/;
        if (passwordPattern.test(passwordInput.val())) {
            passwordInput.removeClass("is-invalid").addClass("is-valid");
        } else {
            passwordInput.removeClass("is-valid").addClass("is-invalid");
        }
    })
}

function fetchItemFromApi(page) {
    fetch(`${linkPageProduct}?page=${page}&size=${itemsPerPage}`, {
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    })
        .then(res => res.json())
        .then((data) => {
            products = data.content.content;
            console.log(products);
            products.map(function (product) {
                // data.map(function (product) {
                let row = `<div class=\"col mb-5\">
                    <div class=\"card h-100\">
                    <img alt=\"...\" class=\"card-img-top\" src=\"${product.imgURL}\"/>
                    <div class=\"card-body p-4\">
                    <div class=\"text-center\">
                    <h5 class=\"fw-bolder\">${product.name}</h5>
                    <span>${product.price}$</span>
                    </div>
                    </div>
                    <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">
                    <div class=\"text-center\">
                    <button class=\"btn btn-outline-dark mt-auto\" data-bs-target=\"#item${product.id}\" data-bs-toggle=\"modal\">View detail</button>
                    </div>
                    </div>
                    </div>
                    </div>`;
                $(`#listProduct`).append(row)
            })
            totalPages = data.totalPages;
            updatePaginationButtons(totalPages);
        })
}

function updatePaginationButtons(totalPages) {
    $('#prevPageBtn').prop('disabled', currentPage === 0);
    $('#nextPageBtn').prop('disabled', currentPage === totalPages - 1);

    $('#currentPageInput').val(currentPage + 1);

    $('#currentPageInput').on('change', function () {
        const newPage = parseInt($(this).val()) - 1;
        if (newPage >= 0 && newPage < totalPages) {
            currentPage = newPage;
            fetchItemFromApi(currentPage);
        } else {
            $(this).val(currentPage + 1);
        }
    });
}

function getItemsToModalsAndAddToCart() {
    fetch(linkAllProduct, {
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    })
        .then(res => res.json())
        .then((data) => {
            data.map(function (product) {
                let row =
                    `<div class="modal fade" id="item${product.id}" tabindex="-1" aria-labelledby="item${product.id}Label" aria-hidden="true">
                    <div class="modal-dialog">
                    <div class="modal-content">
                    <div class="modal-header">
                    <h5 class="modal-title" id="item${product.id}Label">${product.name} Details</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
           
                    <div class="modal-body">
                    <!-- Add product details here -->
                    <img src="${product.imgURL}" alt="..." style="max-width: 100%; max-height: 100%; height: auto;">
                    <p>${product.description}</p>
                    <p>Price: ${product.price}</p>
                    <!-- More details as needed -->
                    <label for="item-quantity">Quantity<\lable>
                    <input type="number" id="item-quantity" required>
                    </div>
                    <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline-dark" id="addItemToCart" data-product-id="${product.id}">Add to cart</button>
                    </div>
                    </div>
                    </div>
                    </div>`;
                $(`#listModalItem`).append(row)
            });

            $(document).on('click', '#addItemToCart', function () {
                if (LoggedUser === undefined) {
                    Toast.fire({
                        icon: 'error',
                        title: `You must login to buy this item!`,
                        timer: 2000
                    });
                } else {
                    const productId = $(this).data('product-id');
                    const quantity = $(this).closest('.modal-content').find('#item-quantity').val();
                    if (quantity === "") {
                        Toast.fire({
                            icon: 'error',
                            title: `Please input item's quantity you want to buy!`,
                            timer: 2000
                        });
                    } else {
                        $.ajax({
                            url: `http://localhost:8080/api/cart/${LoggedUser.id}/add/${productId}`,
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json'
                            },
                            type: 'POST',
                            data: JSON.stringify(quantity),
                            success: function () {
                                console.log('Item added to cart successfully');
                                updateCartBadge(LoggedUser.id)
                                Toast.fire({
                                    icon: 'success',
                                    title: `Add to cart successfully!`,
                                    timer: 2000
                                });
                            },
                            error: function (xhr, status, error) {
                                console.error('Error adding item to cart:', error);
                                Toast.fire({
                                    icon: 'error',
                                    title: `Add to cart fail!`,
                                    timer: 2000
                                });
                            }
                        });
                    }
                }
            })
                .catch(err => console.log(err))
        })
}

function loginAndFetchTokens() {
    const email = $("#email-signin").val();
    const password = $("#password-signin").val();
    const loginData = {
        email: email,
        password: password
    }

    console.log(loginData);

    $.ajax({
        url: "http://localhost:8080/api/auth/login",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(loginData),
        success: (response) => {

            localStorage.setItem("accessToken", response.accessToken);
            localStorage.setItem("refreshToken", response.refreshToken);

            Toast.fire({
                icon: 'success',
                title: 'Signed in successfully',
                timer: 2000
            });
            displayUserAccount(LoggedUser);
            // window.location = 'http://localhost:8080/';
            // Xử lý thành công
        },
        error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
            let timerInterval;
            Swal.fire({
                title: 'Login fail ! Again !',
                html: 'I will close in <b></b> milliseconds.',
                timer: 3000,
                timerProgressBar: true,
                didOpen: () => {
                    Swal.showLoading()
                    const b = Swal.getHtmlContainer().querySelector('b')
                    timerInterval = setInterval(() => {
                        b.textContent = Swal.getTimerLeft()
                    }, 3000)
                },
                willClose: () => {
                    clearInterval(timerInterval)
                }
            }).then((result) => {
                if (result.dismiss === Swal.DismissReason.timer) {
                    window.location.reload();
                }
            })
            // Xử lý lỗi

        }
    });
}

function displayUserAccount() {
    const token = localStorage.getItem('accessToken');
    $.ajax({
        headers: {
            'Authorization': `Bearer ${token}`,
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "/api/user/data",
        success: (user) => {
            LoggedUser = user;
            console.log(LoggedUser)
            document.getElementById("username-btn").textContent = user.email;
            document.getElementById("login-btn").classList.add("visually-hidden");
            let userInfoBtnCss = document.getElementById("user-info-btn").classList;
            userInfoBtnCss.remove("visually-hidden");
            updateCartBadge(LoggedUser.id)
        },
        error: (xhr) => {
            console.log("Error fetching user data:", xhr.responseText);
        }
    })

}

function updateCartBadge(userId) {
    $.ajax({
        url: `http://localhost:8080/api/cart/${userId}/get`,
        type: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        success: function(cartData) {
            const badge = $('#itemQuantity');
            const cartLineCount = cartData.length;

            badge.text(cartLineCount);
        },
        error: function(error) {
            console.error('Error fetching cart data:', error);
        }
    });
}
function logout() {
    $.ajax({
        url:'http://localhost:8080/api/auth/logout',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        success:()=>{
            localStorage.removeItem("accessToken");
            localStorage.removeItem("refreshToken");
            delete $.ajaxSettings.headers["Authorization"]
            location.reload();
        }
    })
}