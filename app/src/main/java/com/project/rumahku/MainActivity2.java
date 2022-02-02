package com.project.rumahku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText etPanjang, etTinggi, etJendela, etPintu, etJendelaLuas, etPintuLuas;
    Button btn_Hitung;
    TextView tvBata, tvSemen, tvPasir, tvHargabata, tvHargasemen, tvHargapasir, tvHargatotal, tvSemenZak;
    CheckBox cbJendela, cbPintu, cbZakLima, cbZakEmpat;
    int bata = 70;
    float pasir = 0.05F;
    float semen = 6.5F;
    int sak50 = 50;
    int sak40 = 40;
    int hasil;
    int hargaBata = 900;
    int hargaPasir =230000;
    int hargaSemen50 =59000;
    int hargaSemen40=48000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etPanjang = findViewById(R.id.etPanjang);
        etTinggi = findViewById(R.id.etTinggi);
        etJendela = findViewById(R.id.etJendela);
        etJendelaLuas = findViewById(R.id.etJendelaLuas);
        etPintu = findViewById(R.id.etPintu);
        etPintuLuas = findViewById(R.id.etPintuLuas);
        btn_Hitung = findViewById(R.id.btn_Hitung);
        tvBata = findViewById(R.id.tvBata);
        tvSemen = findViewById(R.id.tvSemen);
        tvPasir = findViewById(R.id.tvPasir);
        tvHargabata = findViewById(R.id.tvHargabata);
        tvHargapasir = findViewById(R.id.tvHargapasir);
        tvHargasemen = findViewById(R.id.tvHargasemen);
        tvHargatotal = findViewById(R.id.tvHargatotal);
        cbJendela = findViewById(R.id.cbJendela);
        cbPintu = findViewById(R.id.cbPintu);
        cbZakLima = findViewById(R.id.cbZakLima);
        cbZakEmpat = findViewById(R.id.cbZakEmpat);
        tvSemenZak = findViewById(R.id.tvSemenZak);


        btn_Hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PANJANG BELUM TERISI
                if (etPanjang.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Panjangnya Masih Kosong!!", Toast.LENGTH_SHORT).show();
                //LEBAR BELUM TERISI
                } else if (etTinggi.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Tingginya Masih Kosong!!", Toast.LENGTH_SHORT).show();
                //SEMUA UKURAN ZAK TERCENTANG
                } else if(cbZakLima.isChecked() && cbZakEmpat.isChecked()){
                    Toast.makeText(MainActivity2.this, "Silahkan pilih salah satu ukuran zak!!", Toast.LENGTH_SHORT).show();
                //-----------------------------------Semen 50KG-------------------------------------
                } else if (cbZakLima.isChecked() && !cbZakEmpat.isChecked()){
                    //----------------------------JENDELA TERCENTANG--------------------------------
                    if (!cbPintu.isChecked() && cbJendela.isChecked()) {
                        if (etJendela.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah jendela!!", Toast.LENGTH_SHORT).show();
                        }else if (etJendelaLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas jendela!!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Panjang = Integer.valueOf(etPanjang.getText().toString());
                            int Tinggi = Integer.valueOf(etTinggi.getText().toString());
                            int Jendela = Integer.valueOf(etJendela.getText().toString());
                            int luasJendela = Integer.valueOf(etJendelaLuas.getText().toString());

                            int totalP = Jendela * luasJendela;

                            hasil = Panjang * Tinggi - totalP;
                            int totalBata = hasil * bata;
                            float totalPasir = pasir * hasil;
                            float totalSemen = hasil * semen;
                            float totalSemenZakRaw = totalSemen / sak50;
                            if (totalSemen < 50) {
                                totalSemenZakRaw = 1;
                            } else if (totalSemen > 50 && totalSemen < 100) {
                                totalSemenZakRaw = 2;
                            }

                            int totalSemenZak = (int) totalSemenZakRaw;

                            float hargaSemenTotal = hargaSemen50 * totalSemenZakRaw;
                            int hargaBataTotal = hargaBata * totalBata;
                            float hargaPasirTotal = hargaPasir * totalPasir;
                            float totalBahan = hargaBataTotal + hargaSemenTotal + (int) hargaPasirTotal;

                            tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                            tvBata.setText(String.valueOf(totalBata));
                            tvPasir.setText(String.valueOf(totalPasir) + "m³");
                            tvSemen.setText(String.valueOf(totalSemen) + "kg");
                            tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                            tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                            tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                            tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                        }
                    //-----------------------------PINTU TERCENTANG---------------------------------
                    } else if (cbPintu.isChecked() && !cbJendela.isChecked()) {
                        if (etPintu.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah Pintu!!", Toast.LENGTH_SHORT).show();
                        }else if (etPintuLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas Pintu!!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Panjang = Integer.valueOf(etPanjang.getText().toString());
                            int Tinggi = Integer.valueOf(etTinggi.getText().toString());
                            int Pintu = Integer.valueOf(etPintu.getText().toString());
                            int luasPintu = Integer.valueOf(etPintuLuas.getText().toString());

                            int totalP = Pintu * luasPintu;

                            hasil = Panjang * Tinggi - totalP;
                            int totalBata = hasil * bata;
                            float totalPasir = pasir * hasil;
                            float totalSemen = hasil * semen;
                            float totalSemenZakRaw = totalSemen / sak50;
                            if (totalSemen < 50) {
                                totalSemenZakRaw = 1;
                            } else if (totalSemen > 50 && totalSemen < 100) {
                                totalSemenZakRaw = 2;
                            }

                            int totalSemenZak = (int) totalSemenZakRaw;

                            float hargaSemenTotal = hargaSemen50 * totalSemenZakRaw;
                            int hargaBataTotal = hargaBata * totalBata;
                            float hargaPasirTotal = hargaPasir * totalPasir;
                            float totalBahan = hargaBataTotal + hargaSemenTotal + (int) hargaPasirTotal;

                            tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                            tvBata.setText(String.valueOf(totalBata));
                            tvPasir.setText(String.valueOf(totalPasir) + "m³");
                            tvSemen.setText(String.valueOf(totalSemen) + "kg");
                            tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                            tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                            tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                            tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                        }
                    //------------------------PINTU DAN JENDELA TERCENTANG--------------------------
                    } else if (cbPintu.isChecked() && cbJendela.isChecked()) {
                        if (etJendela.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah Jendela!!", Toast.LENGTH_SHORT).show();
                        }else if (etJendelaLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas Jendela!!", Toast.LENGTH_SHORT).show();
                        }else if (etPintu.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah Pintu!!", Toast.LENGTH_SHORT).show();
                        }else if (etPintuLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas Pintu!!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Panjang = Integer.valueOf(etPanjang.getText().toString());
                            int Tinggi = Integer.valueOf(etTinggi.getText().toString());
                            int Pintu = Integer.valueOf(etPintu.getText().toString());
                            int luasPintu = Integer.valueOf(etPintuLuas.getText().toString());
                            int Jendela = Integer.valueOf(etJendela.getText().toString());
                            int luasJendela = Integer.valueOf(etJendelaLuas.getText().toString());

                            int totalJP = Jendela * luasJendela + Pintu * luasPintu;

                            hasil = Panjang * Tinggi - totalJP;
                            int totalBata = hasil * bata;
                            float totalPasir = pasir * hasil;
                            float totalSemen = hasil * semen;
                            float totalSemenZakRaw = totalSemen / sak50;
                            if (totalSemen < 50) {
                                totalSemenZakRaw = 1;
                            } else if (totalSemen > 50 && totalSemen < 100) {
                                totalSemenZakRaw = 2;
                            }

                            int totalSemenZak = (int) totalSemenZakRaw;

                            float hargaSemenTotal = hargaSemen50 * totalSemenZakRaw;
                            int hargaBataTotal = hargaBata * totalBata;
                            float hargaPasirTotal = hargaPasir * totalPasir;
                            float totalBahan = hargaBataTotal + hargaSemenTotal + (int) hargaPasirTotal;

                            tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                            tvBata.setText(String.valueOf(totalBata));
                            tvPasir.setText(String.valueOf(totalPasir) + "m³");
                            tvSemen.setText(String.valueOf(totalSemen) + "kg");
                            tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                            tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                            tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                            tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                        }
                    //--------------------PINTU DAN JENDELA TIDAK TERCENTANG------------------------
                    } else {
                        int Panjang = Integer.valueOf(etPanjang.getText().toString());
                        int Tinggi = Integer.valueOf(etTinggi.getText().toString());

                        hasil = Panjang * Tinggi;
                        int totalBata = hasil * bata;
                        float totalPasir = pasir * hasil;
                        float totalSemen = hasil * semen;
                        float totalSemenZakRaw = totalSemen / sak50;
                        if (totalSemen < 50){
                            totalSemenZakRaw = 1;
                        }else if(totalSemen >50 && totalSemen <100){
                            totalSemenZakRaw = 2;
                        }

                        int totalSemenZak = (int) totalSemenZakRaw;

                        float hargaSemenTotal = hargaSemen50 * totalSemenZakRaw;
                        int hargaBataTotal = hargaBata * totalBata;
                        float hargaPasirTotal = hargaPasir * totalPasir;
                        float totalBahan = hargaBataTotal + hargaSemenTotal + (int)hargaPasirTotal;

                        tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                        tvBata.setText(String.valueOf(totalBata));
                        tvPasir.setText(String.valueOf(totalPasir) + "m³");
                        tvSemen.setText(String.valueOf(totalSemen) + "kg");
                        tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                        tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                        tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                        tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                    }

                //--------------------------------------SEMEN 40KG----------------------------------
                }else if (!cbZakLima.isChecked() && cbZakEmpat.isChecked()){
                    //------------------------------JENDELA TERCENTANG------------------------------
                    if (!cbPintu.isChecked() && cbJendela.isChecked()) {
                        if (etJendela.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah jendela!!", Toast.LENGTH_SHORT).show();
                        }else if (etJendelaLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas jendela!!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Panjang = Integer.valueOf(etPanjang.getText().toString());
                            int Tinggi = Integer.valueOf(etTinggi.getText().toString());
                            int Jendela = Integer.valueOf(etJendela.getText().toString());
                            int luasJendela = Integer.valueOf(etJendelaLuas.getText().toString());

                            int totalP = Jendela * luasJendela;

                            hasil = Panjang * Tinggi - totalP;
                            int totalBata = hasil * bata;
                            float totalPasir = pasir * hasil;
                            float totalSemen = hasil * semen;
                            float totalSemenZakRaw = totalSemen / sak40;
                            if (totalSemen < 40) {
                                totalSemenZakRaw = 1;
                            } else if (totalSemen > 40 && totalSemen < 80) {
                                totalSemenZakRaw = 2;
                            }

                            int totalSemenZak = (int) totalSemenZakRaw;

                            float hargaSemenTotal = hargaSemen40 * totalSemenZakRaw;
                            int hargaBataTotal = hargaBata * totalBata;
                            float hargaPasirTotal = hargaPasir * totalPasir;
                            float totalBahan = hargaBataTotal + hargaSemenTotal + (int) hargaPasirTotal;

                            tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                            tvBata.setText(String.valueOf(totalBata));
                            tvPasir.setText(String.valueOf(totalPasir) + "m³");
                            tvSemen.setText(String.valueOf(totalSemen) + "kg");
                            tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                            tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                            tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                            tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                        }
                    //-----------------------------PINTU TERCENTANG---------------------------------
                    } else if (cbPintu.isChecked() && !cbJendela.isChecked()) {
                        if (etPintu.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah Pintu!!", Toast.LENGTH_SHORT).show();
                        }else if (etPintuLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas Pintu!!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Panjang = Integer.valueOf(etPanjang.getText().toString());
                            int Tinggi = Integer.valueOf(etTinggi.getText().toString());
                            int Pintu = Integer.valueOf(etPintu.getText().toString());
                            int luasPintu = Integer.valueOf(etPintuLuas.getText().toString());

                            int totalP = Pintu * luasPintu;

                            hasil = Panjang * Tinggi - totalP;
                            int totalBata = hasil * bata;
                            float totalPasir = pasir * hasil;
                            float totalSemen = hasil * semen;
                            float totalSemenZakRaw = totalSemen / sak40;
                            if (totalSemen < 40) {
                                totalSemenZakRaw = 1;
                            } else if (totalSemen > 40 && totalSemen < 80) {
                                totalSemenZakRaw = 2;
                            }

                            int totalSemenZak = (int) totalSemenZakRaw;

                            float hargaSemenTotal = hargaSemen40 * totalSemenZakRaw;
                            int hargaBataTotal = hargaBata * totalBata;
                            float hargaPasirTotal = hargaPasir * totalPasir;
                            float totalBahan = hargaBataTotal + hargaSemenTotal + (int) hargaPasirTotal;

                            tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                            tvBata.setText(String.valueOf(totalBata));
                            tvPasir.setText(String.valueOf(totalPasir) + "m³");
                            tvSemen.setText(String.valueOf(totalSemen) + "kg");
                            tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                            tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                            tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                            tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                        }
                    //-------------------------PINTU DAN JENDELA TERCENTANG-------------------------
                    } else if (cbPintu.isChecked() && cbJendela.isChecked()) {
                        if (etJendela.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah Jendela!!", Toast.LENGTH_SHORT).show();
                        }else if (etJendelaLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas Jendela!!", Toast.LENGTH_SHORT).show();
                        }else if (etPintu.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Jumlah Pintu!!", Toast.LENGTH_SHORT).show();
                        }else if (etPintuLuas.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity2.this, "Masukkan Luas Pintu!!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Panjang = Integer.valueOf(etPanjang.getText().toString());
                            int Tinggi = Integer.valueOf(etTinggi.getText().toString());
                            int Pintu = Integer.valueOf(etPintu.getText().toString());
                            int luasPintu = Integer.valueOf(etPintuLuas.getText().toString());
                            int Jendela = Integer.valueOf(etJendela.getText().toString());
                            int luasJendela = Integer.valueOf(etJendelaLuas.getText().toString());

                            int totalJP = Jendela * luasJendela + Pintu * luasPintu;

                            hasil = Panjang * Tinggi - totalJP;
                            int totalBata = hasil * bata;
                            float totalPasir = pasir * hasil;
                            float totalSemen = hasil * semen;
                            float totalSemenZakRaw = totalSemen / sak40;
                            if (totalSemen < 40) {
                                totalSemenZakRaw = 1;
                            } else if (totalSemen > 40 && totalSemen < 80) {
                                totalSemenZakRaw = 2;
                            }

                            int totalSemenZak = (int) totalSemenZakRaw;

                            float hargaSemenTotal = hargaSemen40 * totalSemenZakRaw;
                            int hargaBataTotal = hargaBata * totalBata;
                            float hargaPasirTotal = hargaPasir * totalPasir;
                            float totalBahan = hargaBataTotal + hargaSemenTotal + (int) hargaPasirTotal;

                            tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                            tvBata.setText(String.valueOf(totalBata));
                            tvPasir.setText(String.valueOf(totalPasir) + "m³");
                            tvSemen.setText(String.valueOf(totalSemen) + "kg");
                            tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                            tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                            tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                            tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                        }
                    //----------------------PINTU DAN JENDELA TIDAK TERCENTANG----------------------
                    } else {
                        int Panjang = Integer.valueOf(etPanjang.getText().toString());
                        int Tinggi = Integer.valueOf(etTinggi.getText().toString());

                        hasil = Panjang * Tinggi;
                        int totalBata = hasil * bata;
                        float totalPasir = pasir * hasil;
                        float totalSemen = hasil * semen;
                        float totalSemenZakRaw = totalSemen / sak40;
                        if (totalSemen < 40){
                            totalSemenZakRaw = 1;
                        }else if(totalSemen >40 && totalSemen <80){
                            totalSemenZakRaw = 2;
                        }

                        int totalSemenZak = (int) totalSemenZakRaw;

                        float hargaSemenTotal = hargaSemen40 * totalSemenZakRaw;
                        int hargaBataTotal = hargaBata * totalBata;
                        float hargaPasirTotal = hargaPasir * totalPasir;
                        float totalBahan = hargaBataTotal + hargaSemenTotal + (int)hargaPasirTotal;

                        tvHargatotal.setText("Rp" + String.valueOf((int) totalBahan));
                        tvBata.setText(String.valueOf(totalBata));
                        tvPasir.setText(String.valueOf(totalPasir) + "m³");
                        tvSemen.setText(String.valueOf(totalSemen) + "kg");
                        tvSemenZak.setText(String.valueOf(totalSemenZak) + " Zak");
                        tvHargabata.setText("Rp" + String.valueOf((int) hargaBataTotal));
                        tvHargapasir.setText("Rp" + String.valueOf((int) hargaPasirTotal));
                        tvHargasemen.setText("Rp" + String.valueOf((int) hargaSemenTotal));
                    }

                }else {
                    //TIDAK ADA UKURAN ZAK YANG TERCENTANG
                    Toast.makeText(MainActivity2.this, "Silahkan pilih ukuran zak!!", Toast.LENGTH_SHORT).show();

                }


            }

            //private void hitungBata() {
            //    int bataTotal = (int) (bata * hasil);
            //}
        });
}}