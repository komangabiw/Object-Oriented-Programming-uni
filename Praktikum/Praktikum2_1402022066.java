public class Praktikum2_1402022066 {
	public static void main(String[] args) {
		PenjualanBarang data1 = new PenjualanBarang("Semen Merek Kaki Empat", 12000, 10, 7000);
		PenjualanBarang data2 = new PenjualanBarang("Cat 5L Merek No drip", 105300, 30, 7000);
		PenjualanBarang data3 = new PenjualanBarang("Keramik Merek Caunima", 32000, 10, 7000);
		PenjualanBarang data4 = new PenjualanBarang("Toren Merek Beruang", 20000, 14, 7000);
		PenjualanBarang data5 = new PenjualanBarang("Keyboard Gaming Cuyy", 10000, 10, 7000);
		PenjualanBarang data6 = new PenjualanBarang("Toren Merek Kuda", 52000, 18, 7000);
		PenjualanBarang data7 = new PenjualanBarang("Mouse Gaming Cuyy", 4540000, 8, 7000);
		PenjualanBarang data8 = new PenjualanBarang("Panci Merek Beruang", 12400, 20, 7000);
		PenjualanBarang data9 = new PenjualanBarang("Monitor Gaming Cuyy", 87600, 30, 7000);
		PenjualanBarang data10 = new PenjualanBarang("Laptop Gaming Cuyy", 10042, 25, 7000);

		PenjualanBarang[] data = {data1, data2, data3, data4, data5, data6, data7, data8, data9, data10};
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("Nama Barang\t\t\t\t| Harga Barang\t\t| Jumlah Terjual\t| Harga Modal");
		System.out.println("---------------------------------------------------------------------------------------------------");
		double total = 0;
		for(PenjualanBarang hasil : data){
			hasil.show();
			total += hasil.getProfit();
		}
		System.out.println("---------------------------------------------");
		System.out.println("Total profit : Rp. " + (int)total);
	}
}

class PenjualanBarang {
	private String namaBarang;
	private double hargaBarang;
	private int jumlahTerjual;
	private double hargaModal;

	private String getBarang(){
		return this.namaBarang;
	}
	private double getHarga(){
		return this.hargaBarang;
	}
	private int getJumlahTerjual(){
		return this.jumlahTerjual;
	}

	double getProfit(){
		double hasil = 0;
		hasil += (hargaBarang - hargaModal) * jumlahTerjual;
		return hasil;
	}

	void show(){
		System.out.println(this.namaBarang + "\t\t\t| Rp. " + (int) this.hargaBarang + "\t\t| " + this.jumlahTerjual +"\t\t\t| " + this.hargaModal);
	}

	PenjualanBarang(String inputNama, double inputHarga, int inputLaku, double inputHargaModal){
		this.namaBarang = inputNama;
		this.hargaBarang = inputHarga;
		this.jumlahTerjual = inputLaku;
		this.hargaModal = inputHargaModal;
	}
}
