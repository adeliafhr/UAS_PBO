# Aplikasi CRUD dan Login Java Swing menggunakan Persistance dan Laporan iReport

---
## 🗂️ Table Of Contents 
- [Login](https://github.com/adeliafhr/UAS_PBO/blob/main/Login.java)
- [CRUD](https://github.com/adeliafhr/UAS_PBO/blob/main/Mahasiswa.java)
- [iReport](https://github.com/adeliafhr/UAS_PBO/blob/main/report_mhs.jasper)

---
##  📋 Langkah - Langkah Penggunaan
## A) Persistance
### 1. Membuat database pada postgreSQL dengan nama `Mahasiswa` dan `Akun`
![image](https://github.com/user-attachments/assets/0f26cd5a-9de0-4edd-898c-c7c21d7849c1)

---
### 2. Membuat project pada neatbens
---
### 3. Menambahkan Library yang dibutuhkan (Jdk, PostgreSQL dan JasperReport)
![image](https://github.com/user-attachments/assets/a0f32853-fa95-4636-b43c-7aad0ee6c743)

---
### 4. Membuat persistence unit dengan cara klik kanan project lalu pilih `Entity class from Database`
![image](https://github.com/user-attachments/assets/c28cee2d-654b-47c7-95da-7f71dc295a44)

---
### 5. Pilih koneksi database dan pindahkan tabel akun dan mahasiswa pada kotak sebelah kanan
![uasPersis1fix](https://github.com/user-attachments/assets/70b815ed-ca46-4223-bd69-6ceaac0808db)

---
### 6. Jika entity class sudah benar maka klik next
![uasPersis2](https://github.com/user-attachments/assets/e729032a-b30e-43da-ae3a-d41ef5fc4f56)

---
### 7. Lalu pilih finish
![uasPersis3](https://github.com/user-attachments/assets/62f89008-5779-4bc1-97d1-fedf8fe32069)

---
### 8. Setelah membuat persistence, maka akan muncul package META-INF dan file Akun.java dan file Mahasiswa_1.java
![image](https://github.com/user-attachments/assets/b0937711-278f-4c88-a219-507c92f3224b)

---
### 9. Membuat desain GUI untuk frame `Mahasiswa`, frame `Buat`, dan frame `Login`
![image](https://github.com/user-attachments/assets/67bad060-4b6a-4fb4-ac21-ac5914853b69)
![image](https://github.com/user-attachments/assets/80ff0c4e-5528-40bd-b026-ef1ad6355453)
![image](https://github.com/user-attachments/assets/08a7882b-b20b-41a0-8d0e-8553c69e467a)

---
### 10. Berikut adalah source code dari frame mahasiswa untuk button insert
<pre>
  private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (tfNim.getText().equals("") || tfNama.getText().equals("") || tfAlamat.getText().equals("") || tfAsal.getText().equals("") 
                || tfOrtu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String nim, nama, alamat, asal_sma, nama_orang_tua;
            nim = tfNim.getText();
            nama = tfNama.getText();
            alamat = tfAlamat.getText();
            asal_sma = tfAsal.getText();
            nama_orang_tua = tfOrtu.getText();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Mahasiswa_1 mhs = new Mahasiswa_1();
            mhs.setNim(nim);
            mhs.setNama(nama);
            mhs.setAlamat(alamat);
            mhs.setAsalSma(asal_sma);
            mhs.setNamaOrangTua(nama_orang_tua);

            em.persist(mhs);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Sukses diinput");

            //bersih();
            tampil();

            em.close();
            emf.close();
       }
    }              
</pre>

---
### 11. Berikut adalah source code dari frame mahasiswa untuk button update
<pre>
private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
// TODO add your handling code here:
  if (tfNim.getText().equals("") || tfNama.getText().equals("") || tfAlamat.getText().equals("") || tfAsal.getText().equals("") 
                || tfOrtu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String nim, nama, alamat, asal_sma, nama_orang_tua;
            nim = tfNim.getText();
            nama = tfNama.getText();
            alamat = tfAlamat.getText();
            asal_sma = tfAsal.getText();
            nama_orang_tua = tfOrtu.getText();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Mahasiswa_1 mhs = em.find(Mahasiswa_1.class, nim);
            if (mhs == null) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            } else {
                mhs.setNim(nim);
                mhs.setNama(nama);
                mhs.setAlamat(alamat);
                mhs.setAsalSma(asal_sma);
                mhs.setNamaOrangTua(nama_orang_tua);

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

                em.close();
                emf.close();
               // bersih();
                tfNim.setEditable(true);
            }
        }
        tampil();
    }                 
</pre>

---
### 12. Berikut adalah source code dari frame mahasiswa untuk button delete
<pre>
  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Validasi input
            if (tfNim.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Masukkan NIM yang akan dihapus");
            } else {
                // Mulai transaksi
                em.getTransaction().begin();

                // Cari entitas Matakuliah berdasarkan kode mata kuliah
                String NIM = tfNim.getText();
                Mahasiswa_1 mhs = em.find(Mahasiswa_1.class, NIM);

                if (mhs != null) {
                    // Hapus entitas jika ditemukan
                    em.remove(mhs);

                    // Commit transaksi
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

                    // Refresh data pada tampilan
                    tampil();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk ISBN: " + NIM);
                    em.getTransaction().rollback();
                }
            }
        } catch (Exception e) {
            // Rollback transaksi jika terjadi kesalahan
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
            System.out.println(e.getMessage());
        } finally {
            em.close();  // Tutup EntityManager setelah oprasi
        }
    }             
</pre>

---
### 13. Berikut adalah source code dari frame mahasiswa untuk button upload menggunakan format .csv
<pre>
  JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePilihan));
                String baris;
                String pemisah = ",";

                // EntityManager untuk database
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin(); // Mulai transaksi

                while ((baris = br.readLine()) != null) {
                    String[] dataMhs = baris.split(pemisah);

                  if (dataMhs.length >= 5) {
                        String nim = dataMhs[0];
                        String nama = dataMhs[1];
                        String alamat = dataMhs[2];
                        String asalsma = dataMhs[3];
                        String namaortu = dataMhs[4];

                        // Buat objek MataKuliah baru
                        Mahasiswa_1 mh = new Mahasiswa_1();
                        mh.setNim(nim);
                        mh.setNama(nama);
                        mh.setAlamat(alamat);
                        mh.setAsalSma(asalsma);
                        mh.setNamaOrangTua(namaortu);

                        // Simpan objek ke database
                        em.persist(mh);
                    }
                }

                em.getTransaction().commit(); // Commit transaksi
                em.close(); // Tutup EntityManager

                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                tampil(); // Refresh tabel GUI

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }          
</pre>

---
### 14. Berikut adalah source code dari frame buat untuk button create
<pre>
  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
          if (tfUser.getText().equals("") || tfPw.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Isi username dan password");
    } else {
        String username, pw;
        username = tfUser.getText();
        pw = tfPw.getText();

        if (pw.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password minimal 8 karakter.");
            return;
        }

        if (!pw.matches("[A-Za-z0-9]+")) {
            JOptionPane.showMessageDialog(null, "Password harus menggunakan huruf");
            return;
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Akun y = em.find(Akun.class, username);
        if (y != null) {
            JOptionPane.showMessageDialog(null, "Username sudah terdaftar, gunakan username lain");
            bersih();
        tfUser.requestFocus();
        } else {
            Akun account = new Akun();
            account.setUsername(username);
            account.setPassword(pw);
            em.persist(account);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Akun berhasil dibuat");
            bersih();

            this.dispose();
            Login frame = new Login();
            frame.setVisible(true);
        }
        em.close();
        emf.close();
          }
    }     
</pre>

---
### 15. Berikut adalah source code dari frame login untuk button login
<pre>
  private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (tfUser.getText().equals("") | tfPw.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi Terlebih Dahulu");
        } else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            String user = tfUser.getText();
            String pw = tfPw.getText();
            Akun y = em.find(Akun.class, user);

            if (y == null) {
                JOptionPane.showMessageDialog(null, "Username tidak ditemukan");
            } else if (y.getPassword().equals(pw)) {
                JOptionPane.showMessageDialog(null, "SELAMAT DATANG!!!");
                Mahasiswa p = new Mahasiswa();
                p.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah!");
            }
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }        
</pre>

---
## B) Membuat Laporan Ireport
---
### 1. Buat report wizard pada project
![image](https://github.com/user-attachments/assets/d243404f-a5f7-4e6d-8fe9-83f21fe7857a)

---
### 2. Pilih layout yang akan dibuat
![image](https://github.com/user-attachments/assets/2b20bd0c-1fe7-4061-88f4-2a2e8909bcf4)

---
### 3. Sambungkan dengan database pada PostgreSQL
![uasReport2](https://github.com/user-attachments/assets/12fdeb26-59b9-4f22-badd-6e1163fb348e)


---
### 4. Masukkan query yang telah tersambung 
![uasReport3](https://github.com/user-attachments/assets/74be8da9-8d09-4c10-b8cc-3a41559f7533)
![uasReport4](https://github.com/user-attachments/assets/97f928be-355f-49a5-920e-dc418a9289a0)

---
### 5. Jika sudah terhubung maka akan muncul seperti ini dan klik finish
![uasReport6](https://github.com/user-attachments/assets/6e0fbb92-e352-42a7-9441-346fe9be504a)

---
### 6. Desain report sesuai dengan keinginan 
![image](https://github.com/user-attachments/assets/5a6f1ad4-47ee-4cac-b4b2-cc4cf6ccda36)

---
### 7. Berikut adalah source code dari frame mahasiswa untuk button cetak
<pre>
  private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        try {
           conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UAS_PBO", "postgres", "adelia19");
            
            JasperReport reports;
            String path = "src\\uas_pbo\\report_mhs.jasper";
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint print = JasperFillManager.fillReport(path, null, conn);
            JasperViewer view = new JasperViewer(print, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
</pre>

---
## 💡Selamat Belajar dan Bereksplorasi dalam Konsep Pemrograman Beorientasi Objek !!📖


