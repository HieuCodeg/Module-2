package doc_ghi_file_nhi_phan;

import java.io.FileOutputStream;

public class WriteFile {
    public static void main(String args[]){
        try{
            FileOutputStream fout=new FileOutputStream("testText.txt",true);
            String s="Xin chào các bạn";
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}
    }
}
