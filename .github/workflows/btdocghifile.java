class SinhVien implements Serializable {
    public String hoTen;
    public int tuoi;
}
 
public class JavaAndroidVn {
 
    public static void main(String[] args) throws IOException {
        SinhVien a = new SinhVien();
        a.hoTen = "Vũ Văn Tường";
        a.tuoi = 21;
 
        try {
            FileOutputStream f = new FileOutputStream("E:\\sinhvien.dat");
            ObjectOutputStream oOT = new ObjectOutputStream(f); // Sử dụng để ghi file theo từng Object
            oOT.writeObject(a); // Ghi  Object là đối tượng a xuống file
            oOT.close();
            f.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra!");
        }
 
        SinhVien a1 = new SinhVien(); //Tạo đối tượng a1 mới, để phía dưới gán bằng đối tượng ta lấy được ra từ file
 
        try {
            FileInputStream f = new FileInputStream("E:\\sinhvien.dat");
            ObjectInputStream oIT = new ObjectInputStream(f); // Sử dụng để đọc file theo từng Object
            a1 = (SinhVien) oIT.readObject(); //Đọc Object đầu tiên ép kiểu về kiểu SinhVien sau đó gán bằng đối tượng a1
            oIT.close();
            f.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy class");
        }
    
        System.out.println("Thông tin sinh vien a1 đọc ra là: \nTên: "+a1.hoTen+"\nTuổi: "+a1.tuoi);
    }
}
