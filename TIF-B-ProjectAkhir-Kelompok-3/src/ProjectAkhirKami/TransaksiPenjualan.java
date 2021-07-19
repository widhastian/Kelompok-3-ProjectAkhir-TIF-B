/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectAkhirKami;

import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.Connectionz;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author asus
 */
public class TransaksiPenjualan extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi
     */
    
    public final Connection conn = new Connectionz().GetConnection();
    
    private DefaultTableModel tabmode;
    
    public TransaksiPenjualan() {
        initComponents();
        setLocationRelativeTo(this);
        aktif();
        autoKdPenjualan();
        autoIdKP_DT();
        tanggal();
        datatabel();
        datatabel2();
        lebarKolom();
        txtKodePenjualan.requestFocus();
        txtIDBarang.setVisible(true);
        txtIDdetailPenjualan.setVisible(true);
        //Locale local = new Locale("id","ID");
    }
    
    public void tanggal(){
        Date tgl = new Date();
        btn_tanggal.setDate(tgl);
    }
    
    private void autoKdPenjualan(){
        try{
         Connection con = new Connectionz().GetConnection();
         java.sql.Statement stat = con.createStatement();
         String sql = "select max(right (kode_penjualan,3)) as no from tblpenjualan";
         ResultSet res = stat.executeQuery(sql);
         while(res.next()){
            if(res.first()==false){
                txtKodePenjualan.setText("BK-001");
            } else {
                res.last();
                int aut_id = res.getInt(1)+1;
                String no = String.valueOf(aut_id);
                int no_jual = no.length();
                // mengatur jumlah 0
                for (int j = 0;j<3 - no_jual;j++){
                    no = "0"+no;
                }
                txtKodePenjualan.setText("BK-"+no);
            }
         }
         res.close();
         stat.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }
    
    private void autoIdKP_DT(){
        try{
         Connection con = new Connectionz().GetConnection();
         java.sql.Statement stat = con.createStatement();
         String sql = "select max(right (id_detail_penjualan,3)) as no from tbldetail_penjualan";
         ResultSet res = stat.executeQuery(sql);
         while(res.next()){
            if(res.first()==false){
                txtIDdetailPenjualan.setText("DTP-001");
            } else {
                res.last();
                int aut_id = res.getInt(1)+1;
                String no = String.valueOf(aut_id);
                int no_jual = no.length();
                // mengatur jumlah 0
                for (int j = 0;j<3 - no_jual;j++){
                    no = "0"+no;
                }
                txtIDdetailPenjualan.setText("DTP-"+no);
            }
         }
         res.close();
         stat.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }
    
    public void NoTable(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    public void NoTable2(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    
    public void lebarKolom(){
        TableColumn column;
        keranjang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = keranjang.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = keranjang.getColumnModel().getColumn(1);
        column.setPreferredWidth(171);
        column = keranjang.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);
        column = keranjang.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        column = keranjang.getColumnModel().getColumn(4);
        column.setPreferredWidth(100);
    }
    
    private void aktif(){
        txtIDdetailPenjualan.setEnabled(true);
        txtKodePenjualan.setEnabled(true);
        txtIDBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        txtHargaSatuan.setEnabled(true);
        txtJumlah.setEnabled(true);
        txtTotalBayar.setEnabled(true);
    }
    
    protected void kosong(){
        txtIDdetailPenjualan.setText(null);
        txtKodePenjualan.setText(null);
        txtIDBarang.setText(null);
        txtNamaBarang.setText(null);
        txtHargaSatuan.setText(null);
        txtJumlah.setText(null);
        txtTotalBayar.setText(null);
    }
    
    public void datatabel(){
        Object[] Baris = {"No","Nama Barang","Harga Satuan","Jumlah","Total"};
        tabmode = new DefaultTableModel(null, Baris);
        keranjang.setModel(tabmode);
        String sql = "select * from tbldetail_penjualan order by tgl_transaksi asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String nama = hasil.getString("nama_barang");
                String harga = hasil.getString("harga_satuan");
                String jumlah = hasil.getString("jumlah_beli");
                String total = hasil.getString("total_bayar");
                String[] data = {"",nama,harga,jumlah,total};
                tabmode.addRow(data);
                NoTable();
            }
        } catch (Exception e){
        }
    }
    
    public void datatabel2(){
        Object[] Baris = {"No","ID Barang","Nama Barang","Harga Satuan"};
        tabmode = new DefaultTableModel(null, Baris);
        barang.setModel(tabmode);
        String sql = "select * from tblbarang order by id_barang asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idbar = hasil.getString("id_barang");
                String nama = hasil.getString("nama_barang");
                String harga = hasil.getString("harga_satuan");
                String[] data = {"",idbar,nama,harga};
                tabmode.addRow(data);
                NoTable2();
            }
        } catch (Exception e){
        }
    }
    
    private void total(){
        String harga = txtHargaSatuan.getText();
        String jumlah = txtJumlah.getText();
        
        int hargaa = Integer.parseInt(harga);
        try{
        int jumlahh = Integer.parseInt(jumlah);
        
        int total = hargaa * jumlahh;
        String total_harga = Integer.toString(total);
        
        txtTotalBayar.setText(total_harga);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Only Number");
            txtJumlah.setText(null);
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
        btnback = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUang = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        keranjang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtIDUser = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNamaPegawai = new javax.swing.JTextField();
        btn_tanggal = new com.toedter.calendar.JDateChooser();
        btnCetak = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodePenjualan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHargaSatuan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalBayar = new javax.swing.JTextField();
        txtIDBarang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        barang = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        txtIDdetailPenjualan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 229, 233));
        jPanel1.setForeground(new java.awt.Color(74, 28, 64));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 28, 64));
        jLabel1.setText("TRANSAKSI ILNAA COLLECTION ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        btnback.setBackground(new java.awt.Color(231, 152, 174));
        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setForeground(new java.awt.Color(74, 28, 64));
        btnback.setText("KEMBALI");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, -1, -1));

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 230, 33));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(74, 28, 64));
        jLabel11.setText("TOTAL");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        txtUang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtUang, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 230, -1));

        txtKembalian.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKembalianActionPerformed(evt);
            }
        });
        jPanel1.add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 230, -1));

        btnBayar.setBackground(new java.awt.Color(231, 152, 174));
        btnBayar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(74, 28, 64));
        btnBayar.setText("KEMBALIAN");
        jPanel1.add(btnBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 230, 35));

        btnHapus.setBackground(new java.awt.Color(231, 152, 174));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(74, 28, 64));
        btnHapus.setText("DELETE");
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 100, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectAkhirKami/1_1_1_e790ae2c-67a6-45b9-a1dd-d70b127f5322-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1606, 11, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel13.setText("Ilnaa Collection");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1584, 104, -1, -1));

        keranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(keranjang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 520, 150));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(74, 28, 64));
        jLabel3.setText("Tanggal");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        btnReset.setBackground(new java.awt.Color(231, 152, 174));
        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("RESET");
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 100, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("CETAK");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1555, 575, 138, 35));

        jPanel4.setBackground(new java.awt.Color(231, 152, 174));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtIDUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDUserActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(74, 28, 64));
        jLabel15.setText("ID User");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(74, 28, 64));
        jLabel16.setText("Nama Pegawai");

        txtNamaPegawai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 270, -1));

        btn_tanggal.setBackground(new java.awt.Color(231, 152, 174));
        jPanel1.add(btn_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 145, -1));

        btnCetak.setBackground(new java.awt.Color(231, 152, 174));
        btnCetak.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCetak.setText("PRINT");
        jPanel1.add(btnCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 100, -1));

        btnTambah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTambah.setText("ADD");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("BAYAR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(74, 28, 64));
        jLabel5.setText("BARANG");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        txtKodePenjualan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKodePenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodePenjualanActionPerformed(evt);
            }
        });
        txtKodePenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodePenjualanKeyPressed(evt);
            }
        });
        jPanel1.add(txtKodePenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 200, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(74, 28, 64));
        jLabel6.setText("Nama Barang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txtNamaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });
        txtNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangKeyPressed(evt);
            }
        });
        jPanel1.add(txtNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 200, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText(":");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 10, -1));

        txtHargaSatuan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHargaSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHargaSatuanKeyPressed(evt);
            }
        });
        jPanel1.add(txtHargaSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 200, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 28, 64));
        jLabel4.setText("Jumlah");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtJumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahKeyPressed(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 200, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Total");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txtTotalBayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtTotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 200, -1));

        txtIDBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtIDBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 60, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(74, 28, 64));
        jLabel9.setText("Kode Penjualan");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Harga Satuan");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 90, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText(":");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 10, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText(":");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 10, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText(":");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 10, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText(":");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 10, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText(":");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 10, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("CLEAR");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        barang.setModel(new javax.swing.table.DefaultTableModel(
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
        barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(barang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 440, 140));

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 350, -1));

        txtIDdetailPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDdetailPenjualanActionPerformed(evt);
            }
        });
        jPanel1.add(txtIDdetailPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        Admin Login=new Admin();
        Login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtKodePenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodePenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodePenjualanActionPerformed

    private void txtIDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDUserActionPerformed

    private void txtKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKembalianActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if(txtIdBarangKeluar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ID BK tidak boleh kosong");
            txtIdBarangKeluar.requestFocus();
        } else if(txtGudang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Gudang tidak boleh kosong");
            txtGudang.requestFocus();
        } else if (txtKodePart.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kode Part tidak boleh kosong");
            txtKodePart.requestFocus();
        } else if (txtNamaPart.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Part tidak boleh kosong");
            txtNamaPart.requestFocus();
        } else if (txtJumlahBarang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Qty tidak boleh kosong");
            txtJumlahBarang.requestFocus();
        } else {
        String sql = "insert into tb_detail_brg_keluar values (?,?,?,?,?,?,?,?)";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnPilihTanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal.toString());
            stat.setString(2, txtIdDetailBarangKeluar.getText());
            stat.setString(3, txtIdBarangKeluar.getText());
            stat.setString(4, txtGudang.getText());
            stat.setString(5, txtKodePart.getText());
            stat.setString(6, txtNamaPart.getText());
            stat.setString(7, txtJumlahBarang.getText());
            stat.setString(8, txtKeterangan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");
            //            String refresh = "select * from tb_barang";
            autoIdBK();
            autoIdBK_DT();
            kosong2();
            dataTable();
            lebarKolom();
            txtIdBarangKeluar.setEnabled(false);
            txtGudang.setEnabled(false);
            txtKodePart.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambah"+e);
        }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangMouseClicked
        // TODO add your handling code here:
        int bar = barang.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        txtIDBarang.setText(b);
        txtNamaBarang.setText(c);
        txtHargaSatuan.setText(d);
        txtIDBarang.requestFocus();
    }//GEN-LAST:event_barangMouseClicked

    private void txtKodePenjualanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodePenjualanKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_txtKodePenjualanKeyPressed

    private void txtNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtHargaSatuan.requestFocus();
        }
    }//GEN-LAST:event_txtNamaBarangKeyPressed

    private void txtHargaSatuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaSatuanKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtJumlah.requestFocus();
        }
    }//GEN-LAST:event_txtHargaSatuanKeyPressed

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        // TODO add your handling code here: 
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtTotalBayar.requestFocus();
            total();
        }
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void txtIDdetailPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDdetailPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDdetailPenjualanActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable barang;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private com.toedter.calendar.JDateChooser btn_tanggal;
    private javax.swing.JButton btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable keranjang;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHargaSatuan;
    private javax.swing.JTextField txtIDBarang;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JTextField txtIDdetailPenjualan;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKodePenjualan;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaPegawai;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalBayar;
    private javax.swing.JTextField txtUang;
    // End of variables declaration//GEN-END:variables
}
