class PenjualanBarang {
    private String namaBarang;
    private int hargaBarang;
    private int jumlahJual;
    private int hargaModal;
    private int diskon;
    private int hargaDiskon;
    private static final String toko = "DAFTAR PRODUK TOKO MAKMUR";
    private static String hasilTulis;
    public static final String nama(){
        return toko;
    }
    public static String tulisUang(int hargaBarang){
        hasilTulis = String.valueOf(hargaBarang);
        String hasil = "";
        String hasilAkhir = "";
        for (int i = 0; i < hasilTulis.length(); i++) {
            hasil += hasilTulis.charAt(hasilTulis.length() -1 - i);
            if(i%3==2){
                hasil += ",";
            }
        }
        for (int i = 0; i < hasil.length(); i++) {
            hasilAkhir += hasil.charAt(hasil.length() -1 -i);
        }
        if (hasilAkhir.charAt(0) == ',') {
            hasilAkhir = hasilAkhir.substring(1);
        }
        return hasilAkhir; 
    }
    public static String tulisUang(double hargaBarang){
        hasilTulis = String.valueOf(hargaBarang);
        String hasil = "";
        String hasilAkhir = "";
        for (int i = 0; i < hasilTulis.length(); i++) {
            hasil += hasilTulis.charAt(hasilTulis.length() -1 - i);
            if(i%3==2){
                hasil += ",";
            }
        }
        for (int i = 0; i < hasil.length(); i++) {
            hasilAkhir += hasil.charAt(hasil.length() -1 -i);
        }
        if (hasilAkhir.charAt(0) == ',') {
            hasilAkhir = hasilAkhir.substring(1);
        }
        return hasilAkhir; 
    }
    public PenjualanBarang(String nBarang, int hBarang, int jumJual, int hModal){
        namaBarang = nBarang;
        hargaBarang = hBarang;
        jumlahJual = jumJual;
        hargaModal = hModal;
    }
    public PenjualanBarang(String nBarang, int hBarang, int jumJual, int hModal, int diskon){
        namaBarang = nBarang;
        hargaBarang = hBarang;
        jumlahJual = jumJual;
        hargaModal = hModal;
        this.diskon = diskon;
    }
    public String getNamaBarang(){
        return namaBarang;
    }
    public int getHargaBarang(){
        return hargaBarang;
    }
    public int getJumlahJual(){
        return jumlahJual;
    }
    public int getHargaModal(){
        return hargaModal;
    }
    public int getDiskon(){
        return diskon;
    }
    public int getHasilDiskon(){
        if(diskon == 0){
            hargaDiskon = hargaBarang;
        }else{
            hargaDiskon = hargaBarang - ((diskon * hargaBarang)/100);
        }
        return hargaDiskon;
    }
}
public class  Praktikum3_1402022066{
	public static void main(String[] args){
		PenjualanBarang [] br= new PenjualanBarang [10];
		br [0] = new PenjualanBarang("Semen Merek", 130000, 10, 10000, 5);
		br [1] = new PenjualanBarang("Cat 5L Merek", 80000, 30, 50000);
		br [2] = new PenjualanBarang("Keramik Merek", 100000, 10, 90000);
		br [3] = new PenjualanBarang("Semen Kaki", 80000, 70, 70000);
		br [4] = new PenjualanBarang("Triplek Hijau", 110000, 5, 90000, 3);
		br [5] = new PenjualanBarang("Kawat Merah", 40000, 20, 20000);
		br [6] = new PenjualanBarang("Paku Payung", 70000, 10, 50000);
		br [7] = new PenjualanBarang("Genteng Panda", 140000, 15, 110000, 3);
		br [8] = new PenjualanBarang("Pasir Pantai", 290000, 20, 250000);
		br [9] = new PenjualanBarang("Batu Bata", 90000, 1000,50000, 8);
		System.out.println("----------------------------------------------------------------------------------");
        System.out.println(PenjualanBarang.nama());
        
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Nama Produk\t|Harga Barang\t|Jumlah Terjual\t|Harga Modal\t|diskon\t|harga diskon");
		System.out.println("----------------------------------------------------------------------------------");
        for (int i = 0; i < br.length; i++) {
            System.out.println(br[i].getNamaBarang()+"\t|Rp. "+ PenjualanBarang.tulisUang(br [i].getHargaBarang()) +"\t"+ br [i].getJumlahJual()+"\t\tRp. "+ PenjualanBarang.tulisUang(br [i].getHargaModal()) + "\t\t" + br [i].getDiskon()+ "\tRp. " + PenjualanBarang.tulisUang(br[i].getHasilDiskon()));
        }
        int totalJual = 0;
		int totalModal = 0;
		for(int i = 0 ; i < br.length; i++){
			totalJual += br[i].getHargaBarang() * br[i].getJumlahJual();
			totalModal += br[i].getHargaModal() * br[i].getJumlahJual();
		}
		System.out.println("---------------------------------");
		int profit = totalJual - totalModal;
		System.out.println("Total Profit : Rp. " + PenjualanBarang.tulisUang(profit));
	}
}