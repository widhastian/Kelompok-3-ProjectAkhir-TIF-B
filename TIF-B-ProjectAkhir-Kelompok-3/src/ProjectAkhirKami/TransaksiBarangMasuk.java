/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectAkhirKami;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Connectionz;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumn;

/**
 *
 * @author asus
 */
public class TransaksiBarangMasuk extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiBarangMasuk
     */
    //public final Connection conn = new koneksi().connect();

    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;
    
    // frame maks dan geser panel
    //static boolean maximixed = true;
    //int xMouse;
    //int yMouse;
    
    private void aktif(){
        txtIDPemasukan.setEnabled(true);
        txtIDSuplier.setEnabled(true);
        txtIDBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        txtJumlahMasuk.setEnabled(true);
        txtIDUser.setEnabled(true);
    }
    
    protected void kosong(){
        txtIDPemasukan.setText(null);
        txtIDSuplier.setText(null);
        txtIDBarang.setText(null);
        txtNamaBarang.setText(null);
        txtJumlahMasuk.setText(null);
        txtIDUser.setText(null);
    }
    
    public void noTable(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    
    public void tanggal(){
        Date tgl = new Date();
        tanggalmasuk.setDate(tgl);
    }
    
    
    public void datatable(){
        Object[] Baris = {"No","ID Pemasukan","Tanggal Masuk","ID Suplier","ID Barang","Nama Barang","Jumlah Masuk","ID User"};
        tabmode = new DefaultTableModel(null, Baris);
        tabel.setModel(tabmode);
        String sql = "select * from tblpemasukan_barang order by id_pemasukan asc";
        try{
            java.sql.Statement stat = Connectionz.GetConnection().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idmasuk = hasil.getString("id_pemasukan");
                String tanggalmasuk = hasil.getString("tgl_masuk");
                String idsup = hasil.getString("id_suplier");
                String idbar = hasil.getString("id_barang");
                String namabar = hasil.getString("nama_barang");
                String jumlah = hasil.getString("jumlah_masuk");
                String iduser = hasil.getString("id_user");
                String[] data = {"",idmasuk,tanggalmasuk,idsup,idbar,namabar,jumlah,iduser};
                tabmode.addRow(data);
                noTable();
            }
        } catch (Exception e){
        }
    }
    
    public void lebarKolom(){
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = tabel.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(4);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(5);
        column.setPreferredWidth(170);
        column = tabel.getColumnModel().getColumn(6);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(7);
        column.setPreferredWidth(100);
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No","ID Pemasukan","Tanggal Masuk","ID Suplier","ID Barang","Nama Barang","Jumlah Masuk","ID User"};
        tabmode = new DefaultTableModel(null, Baris);
        tabel.setModel(tabmode);
        int brs = tabel.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode.removeRow(1);
        }
        try{
            java.sql.Statement stat = Connectionz.GetConnection().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String kode_part = hasil.getString("kode_part");
                String nama_part = hasil.getString("nama_part");
                String kategori = hasil.getString("kategori");
                String jumlah = hasil.getString("jumlah");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"",tanggal,kode_part,nama_part,kategori,jumlah,keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch(Exception e){
        }
    }
    public TransaksiBarangMasuk() {
        initComponents();
        aktif();
        datatable();
        tanggal();
        lebarKolom();
        txtIDPemasukan.requestFocus();
        setLocationRelativeTo(this);
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIDPemasukan = new javax.swing.JTextField();
        txtIDBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        txtJumlahMasuk = new javax.swing.JTextField();
        txtIDSuplier = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDUser = new javax.swing.JTextField();
        btnBersih = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        tanggalmasuk = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 229, 233));

        jButton1.setBackground(new java.awt.Color(231, 152, 174));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(74, 28, 64));
        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 39)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 28, 64));
        jLabel1.setText("FORM BARANG MASUK");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID Pemasukan");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID Suplier");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tanggal Masuk");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nama Barang");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ID Barang");

        txtIDPemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPemasukanActionPerformed(evt);
            }
        });

        txtJumlahMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahMasukActionPerformed(evt);
            }
        });

        txtIDSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSuplierActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(231, 152, 174));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(74, 28, 64));
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(231, 152, 174));
        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(74, 28, 64));
        btnHapus.setText("HAPUS");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectAkhirKami/1_1_1_e790ae2c-67a6-45b9-a1dd-d70b127f5322-removebg-preview.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel8.setText("Ilnaa Collection");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Jumlah Masuk");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("ID User");

        btnBersih.setBackground(new java.awt.Color(231, 152, 174));
        btnBersih.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBersih.setText("BERSIH");
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(231, 152, 174));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tabel.setBackground(new java.awt.Color(231, 152, 174));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        btnCari.setBackground(new java.awt.Color(231, 152, 174));
        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIDSuplier, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(txtIDPemasukan, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(txtIDBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(txtNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(txtJumlahMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(txtIDUser))
                            .addComponent(tanggalmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel7))
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIDPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tanggalmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIDSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtJumlahMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBersih)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSuplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSuplierActionPerformed

    private void txtJumlahMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahMasukActionPerformed

    private void txtIDPemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPemasukanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPemasukanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Admin adm=new Admin();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(txtIDPemasukan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ID Pemasukan tidak boleh kosong");
        } else if (txtIDSuplier.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ID Suplier tidak boleh kosong");
        } else if (txtIDBarang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ID Barang tidak boleh kosong");
        } else if (txtNamaBarang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
        }else if (txtJumlahMasuk.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong");
        }else if (txtIDUser.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ID User tidak boleh kosong");
        }else {
        String sql = "insert into tblpemasukan_barang values (?,?,?,?,?,?,?)";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tanggalmasuk.getDate()));
        try {
            PreparedStatement stat = Connectionz.GetConnection().prepareStatement(sql);
            stat.setString(1, txtIDPemasukan.getText());
            stat.setString(2, tanggal.toString());
            stat.setString(3, txtIDSuplier.getText());
            stat.setString(4, txtIDBarang.getText());
            stat.setString(5, txtNamaBarang.getText());
            stat.setString(6, txtJumlahMasuk.getText());
            stat.setString(7, txtIDUser.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            //            String refresh = "select * from tb_barang";
            kosong();
            datatable();
            lebarKolom();
            txtIDPemasukan.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tanggalmasukPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalmasukPropertyChange
        // TODO add your handling code here:
        //if (tanggalmasuk.getDate()!=null){
            //tgl = format.format(tanggalmasuk.getDate());
        //}
    }//GEN-LAST:event_tanggalmasukPropertyChange

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
        // TODO add your handling code here:
        txtIDPemasukan.setText("");
        //txtTanggal.setText("");
        txtIDSuplier.setText("");
        txtIDBarang.setText("");
        txtNamaBarang.setText("");
        txtJumlahMasuk.setText("");
        txtIDUser.setText("");
    }//GEN-LAST:event_btnBersihActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        try {
            Statement statement = (Statement)Connectionz.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from tblbarang where + "
            + "id_pemasukan='" + txtCari.getText() + "'");
            DefaultTableModel tbl= new DefaultTableModel();
            tbl.addColumn("ID Pemasukan");
            tbl.addColumn("Tanggal Masuk");
            tbl.addColumn("ID Suplier");
            tbl.addColumn("ID Barang");
            tbl.addColumn("Nama Barang");
            tbl.addColumn("Jumlah Barang");
            tbl.addColumn("ID User");
            
            tabel.setModel(tbl);
            while (res.next()){
                tbl.addRow(new Object[] {
                    res.getString("id_pemasukan"),
                    res.getString("tgl_masuk"),
                    res.getString("id_suplier"),
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jumlah_masuk"),
                    res.getString("id_user"),
                    });
                    tabel.setModel(tbl);      
            }
        }  
        catch (Exception e) {
                  JOptionPane.showMessageDialog(rootPane, "salah");
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiBarangMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabel;
    public com.toedter.calendar.JDateChooser tanggalmasuk;
    public javax.swing.JTextField txtCari;
    public javax.swing.JTextField txtIDBarang;
    public javax.swing.JTextField txtIDPemasukan;
    public javax.swing.JTextField txtIDSuplier;
    public javax.swing.JTextField txtIDUser;
    public javax.swing.JTextField txtJumlahMasuk;
    public javax.swing.JTextField txtNamaBarang;
    // End of variables declaration//GEN-END:variables
}
