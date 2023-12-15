import lombok.Builder;

public class Runner {
    public static void main(String[] args) {
        Staff customer = Staff.builder()
                .firstName("Trung")
                .lastName("Huynh")
                .email("hqtrung0105@gmail.com")
                .telephone("0362578883")
                .password("Trung0105@")
                .build();
        System.out.println(customer);
    }
}
