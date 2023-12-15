import React, { useEffect, useState } from "react";
import {
    selectBookDetail,
    getBook,
    removeBook,
} from "../../features/book/bookSlice";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";

export default function BookDetail() {
    // const [book, setBook] = useState({});
    const { bookId } = useParams();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const bookDetail = useSelector(selectBookDetail);

    // const getBookDetail = async () => {
    //     // if (bookDetail == null || bookDetail === bookId) {
    //         console.log("dispatch action getBook...")
    //         dispatch(getBook(bookId));
    //     // } else {
    //         console.log("set state book...");
    //         // setBook(bookDetail);
    //     // }
    // };

    useEffect(() => {
        console.log("getBookDetail")
        dispatch(getBook(bookId));

        // eslint-disable-next-line
    }, []);

    function getBackBookList() {
        navigate("/");
        // window.location.reload();
    }

    function removeCurrentBook() {
        if (bookId) {
            dispatch(removeBook(bookId));
            alert(`Remove book ${JSON.stringify(bookDetail)} successfully!!!`);
            navigate("/");
            window.location.reload();
        }
    }

    return (
        <div>
            <h1>Book Detail</h1>
            <p>
                <b>Id:</b> {bookDetail?.id}
            </p>
            <p>
                <b>Title:</b> {bookDetail?.title}
            </p>
            <p>
                <b>Quantity:</b> {bookDetail?.quantity}
            </p>
            <button type="button" onClick={getBackBookList}>
                Back
            </button>
            &nbsp;
            <button type="button" onClick={removeCurrentBook}>
                Remove
            </button>
        </div>
    );
}