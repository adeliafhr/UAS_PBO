/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class Mahasiswa extends javax.swing.JFrame {

    Connection conn;
    Mahasiswa_1 mhs = new Mahasiswa_1();
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
    EntityManager em = emf.createEntityManager();
    /**
     * Creates new form Mahasiswa
     */
    public Mahasiswa() {
        initComponents();
        tampil();
    }

    public void tampil() {
        // TODO code application logi
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UAS_PBOPU");
        EntityManager em = emf.createEntityManager();
        

        try {
            // Buat model tabel dengan kolom yang sesuai
            DefaultTableModel tbnmhs = new DefaultTableModel(new String[]{"NIM", "NAMA", "ALAMAT", "ASAL SMA", "NAMA ORANG TUA"}, 0);

            // Menggunakan NamedQuery "Matakuliah.findAll" untuk mengambil semua data
            List<Mahasiswa_1> Mahasiswa_1List = em.createNamedQuery("Mahasiswa_1.findAll", Mahasiswa_1.class).getResultList();

            // Iterasi hasil query dan tambahkan baris ke model tabel
            for (Mahasiswa_1 mh : Mahasiswa_1List) {
                tbnmhs.addRow(new Object[]{
                    mh.getNim(),
                    mh.getNama(),
                    mh.getAlamat(),
                    mh.getAsalSma(),
                    mh.getNamaOrangTua()
                }
                );
            }

            // Atur model tabel ke tabel GUI
            Tabel.setModel(tbnmhs);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();  // Tutup EntityManager setelah selesai
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfOrtu = new javax.swing.JTextField();
        tfAsal = new javax.swing.JTextField();
        tfAlamat = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfNim = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("MAHASISWA");

        jLabel2.setText("NIM");

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat");

        jLabel5.setText("Asal SMA");

        jLabel6.setText("Nama Orang Tua");

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnUpload.setText("UPLOAD");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnOut.setText("LOG OUT");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfOrtu)
                            .addComponent(tfAsal)
                            .addComponent(tfAlamat)
                            .addComponent(tfNama)
                            .addComponent(tfNim, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCetak)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpload)
                        .addGap(18, 18, 18)
                        .addComponent(btnOut)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfOrtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCetak)
                            .addComponent(btnUpload)
                            .addComponent(btnOut)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
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
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
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
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
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
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
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
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        Login y = new Login();
        y.setVisible(true);
        this.dispose();
    }                                         

    private void bersih() {
        tfNim.setText("");
        tfNama.setText("");
        tfAlamat.setText("");
        tfAsal.setText("");
        tfOrtu.setText("");
    }//GEN-LAST:event_btnOutActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        int row = Tabel.getSelectedRow();
        tfNim.setText(Tabel.getValueAt(row, 0).toString());
        tfNama.setText(Tabel.getValueAt(row, 1).toString());
        tfAlamat.setText(Tabel.getValueAt(row, 2).toString());
        tfAsal.setText(Tabel.getValueAt(row, 3).toString());     
        tfOrtu.setText(Tabel.getValueAt(row, 3).toString());
    }//GEN-LAST:event_TabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfAsal;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNim;
    private javax.swing.JTextField tfOrtu;
    // End of variables declaration//GEN-END:variables
}
