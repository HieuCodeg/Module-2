package quanlysanpham;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static List<Product> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choosen = -1;
        do {
            showMenu();
            try {
                do {
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.println(" Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        displayProduct();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        deleteProductById();
                        break;
                    case 5:
                        sort();
                        break;
                    case 6:
                        findMax();
                        break;
                    case 7:
                        readProduct();
                        break;
                    case 8:
                        writeProduct();
                        break;
                    case 9:
                        System.out.println("Thoát!!!");
                        break;
                    default:
                        System.out.println(" Nhập sai!!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(" Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 9);
        int choose;


    }

    private static void findMax() {
        int max = 0;
        Product newProduct = new Product();
        for (Product product : productList) {
            if (product.getPrice() > max) {
                max = product.getPrice();
                newProduct = product;
            }
        }
        newProduct.display();

    }

    private static void displayProduct() {
        System.out.println("            ___________________________๑۩۩๑___________________________");
        for (Product product : productList) {
            product.display();
            sc.nextLine();
        }
        System.out.println("                         ________________________________ ");
    }


    private static void sort() {
        System.out.println("Nhập 1 tăng dần");
        System.out.println("Nhập 2 giảm dần");
        System.out.println("Nhập 3 trở lại");
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number == 1) {
                    Collections.sort(productList, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            if (o1.getPrice() > o2.getPrice()) {
                                return 1;
                            }
                            return -1;
                        }
                    });
                    System.out.println("Sắp xếp xong!");
                }
                if (number == 2) {
                    Collections.sort(productList, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            if (o1.getPrice() > o2.getPrice()) {
                                return -1;
                            }
                            return 1;
                        }
                    });
                    System.out.println("Sắp xếp xong!");
                }
                if (number == 3) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai, vui lòng nhập lại!");
            }
        }

    }


    private static void deleteProductById() {
        while (true) {
            System.out.println("Nhập id sản phẩm cần xóa:");
            String id = sc.nextLine();
            if (id.equals("")) {
                return;
            }

            for (Product product : productList) {
                if (product.getId().equals(id)) {
                    System.out.println("Nhấn y để xóa sản phẩm");
                    String chosen = sc.nextLine();
                    if (chosen.equals("y")) {
                        productList.remove(product);
                        System.out.println("Xóa sản phẩm thành công!");
                        return;
                    }
                    break;
                }
            }
            System.out.println("Không tìm thấy sản phẩm với mã sản phẩm trên. Vui lòng nhập lại!");
        }
    }

    public static void edit() {
        while (true) {
            System.out.println("Nhập mã sản phẩm cần sửa:");
            String id = sc.nextLine();
            if (id.equals("")) {
                return;
            }

            for (Product product : productList) {
                if (product.getId().equals(id)) {
                    editProduct(product);
                    return;
                }
            }
            System.out.println("Không tìm thấy sản phẩm với mã sản phẩm trên. Vui lòng nhập lại!");
        }

    }

    public static void editProduct(Product product) {
        System.out.println("Nhập thông tin cần sửa (Nếu không sửa thì để trống) ");
        try {
            System.out.println("Nhập mã sản phẩm : ");
            String id = sc.nextLine();

            System.out.println("Nhập tên sản phẩm: ");
            String name = sc.nextLine();

            System.out.println("Nhập giá (Không sửa nhập 0): ");
            int price = Integer.parseInt(sc.nextLine());

            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(sc.nextLine());

            System.out.println("Nhập mô tả: ");
            String describe = sc.nextLine();
            if (!id.equals("")) {
                product.setId(id);
            }
            if (!name.equals("")) {
                product.setName(name);
            }
            if (!(price == 0)) {
                product.setPrice(price);
            }
            if (!(quantity == 0)) {
                product.setQuantity(quantity);
            }
            if (!describe.equals("")) {
                product.setDescribe(describe);
            }
            System.out.println("Cập nhật thành công!");
        } catch (Exception e) {
            System.out.println("Nhập sai!!!");
        }
    }


    private static void addProduct() {
        while (true) {
            try {
                System.out.println("Nhập mã sản phẩm: ");
                String id = sc.nextLine();

                System.out.println("Nhập tên sản phẩm: ");
                String name = sc.nextLine();
                if (name.trim().equals("")) {
                    System.out.println("Không được để trống!");
                    continue;
                }

                System.out.println("Nhập giá: ");
                int price = Integer.parseInt(sc.nextLine());

                System.out.println("Nhập số lượng: ");
                int quantity = Integer.parseInt(sc.nextLine());

                System.out.println("Nhập mô tả: ");
                String describe = sc.nextLine();
                if (name.trim().equals("")) {
                    System.out.println("Không được để trống!");
                    continue;
                }

                Product product = new Product(id, name, price, quantity, describe);
                productList.add(product);
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai, vui lòng nhập lại!");
            }
        }


    }


    public static void writeProduct() throws IOException {
        System.out.println("LƯU VÀO FILE!!!");
        System.out.println("Nhấp y để bắt đầu lưu");
        String chosen = sc.nextLine();
        if (!(chosen.equals("y"))) {
            return;
        }
        System.out.println("Bắt đầu lưu:--->>> ");
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("data/products.csv");

            for (Product product : productList) {
                String line = product.toString();
                byte[] b = line.getBytes("utf8");
                file.write(b);
            }

            file.close();
            System.out.println("=> Lưu thành công, ấn phím bất kì để trở lại");
            sc.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readProduct() {
        System.out.println("Đọc file sẽ xóa hết danh sách trong bộ nhớ!!!");
        System.out.println("Nhấp q để hủy");
        String chosen = sc.nextLine();
        if (chosen.equals("q")) {
            return;
        }
        productList.clear();
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            fis = new FileInputStream("data/products.csv");

            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Product product = new Product();
                product.parse(line);

                productList.add(product);
            }

            fis.close();
            reader.close();
            bufferedReader.close();
            System.out.println("Đọc thành công!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showMenu() {
        System.out.println("︻╦╤─ ҉ – –CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM  – – – ҉ ─╤╦︻ ");
        System.out.println("       Chọn chức năng theo số (để tiếp tục)");
        System.out.println("    1. Xem danh sách              ");
        System.out.println("    2. Thêm mới       ");
        System.out.println("    3. Cập nhật       ");
        System.out.println("    4. Xóa           ");
        System.out.println("    5. Sắp xếp           ");
        System.out.println("    6. Tìm sản phẩm có giá đắt nhất           ");
        System.out.println("    7. Đọc từ file           ");
        System.out.println("    8. Ghi vào file  ");
        System.out.println("    9. Thoát ☠️                  ");
        System.out.println("︻╦╤─ ҉ – – – –– –– –– –– ––– ––  – – – ҉ ─╤╦︻ ");
        System.out.print(" CHỌN CHỨC NĂNG: ");
    }
}
