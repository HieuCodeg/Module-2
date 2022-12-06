package quan_li_san_pham;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static List<Product> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int choose;

        do {
            showMenu();
            productList.clear();
            Product.count = 0;
            readProduct();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    addProduct();
                    writeProduct();
                    back();
                    break;
                case 2:
                    editProductById();
                    back();
                    break;
                case 3:
                    deleteProductById();
                    back();
                    break;
                case 4:
                    sortProductByPrice();
                    writeProduct();
                    break;
                case 5:
                    sortProductByName();
                    writeProduct();
                    break;
                case 6:
                    sortProductById();
                    writeProduct();
                    break;
                case 7:
                    findProduct();
                    back();
                    break;
                case 8:
                    displayProduct();
                    back();
                    break;
                case 9:
                    System.out.println("Thoát!!!");
                    break;
                default:
                    System.out.println("Nhập sai!!!");
                    break;
            }
        } while (choose != 9);
    }

    private static void displayProduct() {
        System.out.println("            ___________________________๑۩۩๑___________________________");
        for (Product product: productList) {
           product.display();
        }
        System.out.println("                         ________________________________ ");
    }

    private static void findProduct() {
        System.out.println("Nhập tên sản phẩm tìm kiếm");
        String nameProduct = sc.nextLine();
        boolean isExist = false;
        for (Product product: productList) {
            if (product.getName().toUpperCase().equals(nameProduct.toUpperCase())) {
                System.out.println("___________________________๑۩۩๑___________________________");
                product.display();
                System.out.println("              ________________________________ ");
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy sản phẩm");
        }

    }
    private static void sortProductById() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                }
                return -1;
            }
        });
        System.out.println("Sắp xếp xong!");
    }
    private static void sortProductByName() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println("Sắp xếp xong!");
    }

    private static void sortProductByPrice() {
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

    private static void deleteProductById() throws IOException {
        System.out.println("Nhập id sản phẩm cần xóa:");
        int id = -1;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id < 0 || id > productList.size()) {
            System.out.println("ID invalid!!!");
            return;
        }
        for (Product product: productList) {
            if (product.getId() == id ) {
                productList.remove(product);
                break;
            }
        }
        writeProduct();
    }

    private static void editProductById() throws IOException {
        System.out.println("Nhập id sản phẩm cần sửa:");
        int id = -1;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id < 0 || id > productList.size()) {
            System.out.println("ID invalid!!!");
            return;
        }
        for (Product product: productList) {
            if (product.getId() == id ) {
                product.add();
                break;
            }
        }
        writeProduct();
    }

    private static void addProduct() {
        Product newProduct = new Product();
        newProduct.add();

        productList.add(newProduct);

    }

    public static void back() {
        System.out.println("\n Nhấn phím bất kỳ để trở lại ︻┳デ═— :");
        sc.nextLine();
    }

    public static void writeProduct() throws IOException {
        System.out.println("Bắt đầu lưu:--->>> ");
        FileOutputStream file = null;
        try {
             file = new FileOutputStream("products.txt");

            for (Product product: productList) {
                String line = product.getFileLine();
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
        productList.clear();
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        List<Product> products = new ArrayList<>();
        try {
            fis = new FileInputStream("products.txt");

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
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showMenu() {
        System.out.println("︻╦╤─ ҉ – – – –– –– –MENU– –– ––  – – – ҉ ─╤╦︻ ");
        System.out.println("   【⏬】 1. Thêm sản phẩm               【⏬】");
        System.out.println("   【⏬】 2. Sửa sản phẩm theo id        【⏬】 ");
        System.out.println("   【⏬】 3. Xóa sản phẩm theo id        【⏬】 ");
        System.out.println("   【⏬】 4. Sắp xếp theo giá            【⏬】 ");
        System.out.println("   【⏬】 5. Sắp xếp theo tên            【⏬】 ");
        System.out.println("   【⏬】 6. Sắp xếp theo ID             【⏬】 ");
        System.out.println("   【⏬】 7. Tìm kiếm sản phẩm           【⏬】 ");
        System.out.println("   【⏬】 8. Hiển thị danh sách sản phẩm 【⏬】 ");
        System.out.println("   【⏩】 9. Thoát ☠️                 【⏪】 ");
        System.out.println("︻╦╤─ ҉ – – – –– –– –– –– ––– ––  – – – ҉ ─╤╦︻ ");
        System.out.print  (" Chọn ▬▬ι═══════ﺤ(҂`_´): ");
    }
}
