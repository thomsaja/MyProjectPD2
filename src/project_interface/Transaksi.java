/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Thomas
 */
public class Transaksi extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode1;
    private DefaultTableModel tabmode2;

    JasperDesign jasperDesign;
    JasperReport JasRep;
    JasperPrint JasPri;

    private String tgl;

    protected void aktif() {
        txtTransaksi.setEnabled(true);
        txtNama.setEnabled(true);
        txtNo.setEnabled(true);
        txtEmail.setEnabled(true);
        txtNominal.setEnabled(true);
        txtTotal.setEnabled(true);
        txtBayar.setEnabled(true);
        txtStatus.setEnabled(true);
        txtKembalian.setEnabled(true);
        txtTransaksi.requestFocus();
    }

    protected void kosong() {
        txtTransaksi.setText("");
        txtNama.setText("");
        txtNo.setText("");
        txtEmail.setText("");
        txtNominal.setText("");
        txtTotal.setText("");
        txtBayar.setText("");
        txtStatus.setText("");
        txtKembalian.setText("");
    }

    protected void datatablemenu() {
        Object[] Baris = {"Id Menu", "Nominal", "Harga Pulsa"};
        tabmode1 = new DefaultTableModel(null, Baris);
        tableMenu.setModel(tabmode1);
        String sql = "select * from Pulsa";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String Id_Menu = hasil.getString("Id_Menu");
                String Nominal = hasil.getString("Nominal");
                String Harga = hasil.getString("Harga");

                String[] data = {Id_Menu, Nominal, Harga};
                tabmode1.addRow(data);
            }
        } catch (Exception e) {

        }
    }

    protected void datatablePelanggan() {
        Object[] Baris = {"Id Menu", "Nama Pelanggan", "Nomor HP", "E-mail", "Bayar", "Status", "Tanggal", "Id Menu"};
        tabmode2 = new DefaultTableModel(null, Baris);
        tablePelanggan.setModel(tabmode2);
        String sql = "select * from Transaksi order by Id_Transaksi";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String Id_Transaksi = hasil.getString("Id_Transaksi");
                String Nama = hasil.getString("Nama");
                String Nomor = hasil.getString("Nomor");
                String Email = hasil.getString("Email");
                String Bayar = hasil.getString("Bayar");
                String Status = hasil.getString("Status");
                String Tanggal = hasil.getString("Tanggal");
                String Id_Menu = hasil.getString("Id_Menu");

                String[] data = {Id_Transaksi, Nama, Nomor, Email, Bayar, Status, Tanggal, Id_Menu};
                tabmode2.addRow(data);
            }
        } catch (Exception e) {

        }
    }

    protected void datatable() {
        Object[] Baris = {"Id Transaksi", "Pelanggan", "No HP", "Nominal", "Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tableTRANSAKSI.setModel(tabmode);
        String sql = "SELECT * FROM detail_bon order by Id_Transaksi";

        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String Id_Transaksi = hasil.getString("Id_Transaksi");
                String Nama = hasil.getString("Nama");
                String Nomor = hasil.getString("Nomor");
                String Nominal = hasil.getString("Nominal");
                String Status = hasil.getString("Status");

                String[] data = {Id_Transaksi, Nama, Nomor, Nominal, Status};
                tabmode.addRow(data);
            }
        } catch (Exception e) {

        }
    }

    public static Date getTanggalfromTable(JTable table, int kolom) {
        JTable tabel = table;
        String str_tgl = String.valueOf(table.getValueAt(table.getSelectedRow(), kolom));
        Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (ParseException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tanggal;
    }

    public Transaksi() {
        initComponents();
        datatablemenu();
        datatablePelanggan();
        datatable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        transaksi = new javax.swing.JLabel();
        finish = new javax.swing.JButton();
        back = new javax.swing.JButton();
        nama = new javax.swing.JLabel();
        no = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        bayar = new javax.swing.JLabel();
        nominal = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        totalharga = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        txtNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNominal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTRANSAKSI = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTransaksi = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePelanggan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        kembalian = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        enterKembalian = new javax.swing.JLabel();
        enterStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        caristatus = new javax.swing.JLabel();
        stats = new javax.swing.JComboBox<>();
        print = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        transaksi.setFont(new java.awt.Font("Ravie", 2, 20)); // NOI18N
        transaksi.setText("Info Transaksi");

        finish.setText("Finish");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        nama.setText("Nama Pelanggan");

        no.setText("No HP");

        email.setText("E - Mail");

        bayar.setText("Bayar");

        nominal.setText("Nominal");

        status.setText("Status");

        totalharga.setText("Total Harga");

        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Menu", "Nominal", "Harga"
            }
        ));
        tableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMenu);

        tableTRANSAKSI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Traksaksi", "Pelanggan", "No HP", "Nominal", "Status"
            }
        ));
        tableTRANSAKSI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTRANSAKSIMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableTRANSAKSI);

        jLabel1.setText("Id Transaksi");

        tablePelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Transaksi", "Nama", "Nomor", "E - Mail", "Bayar", "Status", "Tanggal", "Id Menu"
            }
        ));
        tablePelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePelangganMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePelanggan);

        jLabel3.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel3.setText("Data");

        jLabel4.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel4.setText("Hasil");

        jLabel5.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel5.setText("Pembelian");

        tanggal.setText("Tanggal Transaksi");

        kembalian.setText("Kembalian");

        txtKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKembalianActionPerformed(evt);
            }
        });

        txtTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTanggalPropertyChange(evt);
            }
        });

        enterKembalian.setText("(Press Enter)");

        enterStatus.setText("(Press Enter)");

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Nominal Pulsa");

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel6.setText("Data");

        jLabel7.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel7.setText("Pelanggan");

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        caristatus.setText("Cari Status");

        stats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunas", "Hutang" }));

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama)
                            .addComponent(jLabel1)
                            .addComponent(nominal)
                            .addComponent(totalharga)
                            .addComponent(no)
                            .addComponent(email)
                            .addComponent(bayar)
                            .addComponent(tanggal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBayar)
                            .addComponent(txtNo)
                            .addComponent(txtNama)
                            .addComponent(txtEmail)
                            .addComponent(txtNominal)
                            .addComponent(txtTotal)
                            .addComponent(txtTransaksi)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kembalian)
                                    .addComponent(status))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtKembalian)
                                    .addComponent(txtStatus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enterStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(enterKembalian, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(transaksi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caristatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(search)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finish))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(print))
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane3)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nominal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalharga))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bayar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kembalian)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterKembalian))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status)
                            .addComponent(enterStatus))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(caristatus)
                        .addComponent(search)
                        .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insert)
                        .addComponent(Update)
                        .addComponent(delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back)
                            .addComponent(finish)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Finish Yet?", "Thank You", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
            this.dispose();
        }
    }//GEN-LAST:event_finishActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        JOptionPane.showMessageDialog(null, "Back To Menu", "Cancel", JOptionPane.INFORMATION_MESSAGE);
        Sistem_Penjualan_Pulsa w = new Sistem_Penjualan_Pulsa();
        w.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void tableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMouseClicked
        int bar = tableMenu.getSelectedRow();
        String a = tabmode1.getValueAt(bar, 0).toString();
        String b = tabmode1.getValueAt(bar, 1).toString();
        String c = tabmode1.getValueAt(bar, 2).toString();

        txtNominal.setText(b);
        txtTotal.setText(c);
    }//GEN-LAST:event_tableMenuMouseClicked

    private void tableTRANSAKSIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTRANSAKSIMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableTRANSAKSIMouseClicked

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String sql = "insert into transaksi values (?,?,?,?,?,?,?,?)";
        int bar = tableMenu.getSelectedRow();
        String a = tabmode1.getValueAt(bar, 0).toString();
        try {
            String state;
            int buy = Integer.parseInt(txtBayar.getText());
            int get = Integer.parseInt(txtTotal.getText());
            if (buy >= get) {
                state = "Lunas";
            } else {
                state = "Hutang";
            }

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtTransaksi.getText());
            stat.setString(2, txtNama.getText());
            stat.setString(3, txtNo.getText());
            stat.setString(4, txtEmail.getText());
            stat.setString(5, txtBayar.getText());
            stat.setString(6, state);
            stat.setString(7, tgl);
            stat.setString(8, a);

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved", "Insert", JOptionPane.INFORMATION_MESSAGE);
            kosong();
            txtTransaksi.requestFocus();
            datatable();
            datatablePelanggan();
            datatablemenu();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't Saved" + e, "Insert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_insertActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        String sql = "update transaksi set Nama=?, Nomor=?, Email=?, Bayar=?, Status=?, Tanggal=?, Id_Menu=? where Id_Transaksi='" + txtTransaksi.getText() + "'";
        int bar = tableMenu.getSelectedRow();
        String a = tabmode1.getValueAt(bar, 0).toString();
        try {
            String state;
            int buy = Integer.parseInt(txtBayar.getText());
            int get = Integer.parseInt(txtTotal.getText());
            if (buy >= get) {
                state = "Lunas";
            } else {
                state = "Hutang";
            }

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtNama.getText());
            stat.setString(2, txtNo.getText());
            stat.setString(3, txtEmail.getText());
            stat.setString(4, txtBayar.getText());
            stat.setString(5, state);
            stat.setString(6, tgl);
            stat.setString(7, a);

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved", "Update", JOptionPane.INFORMATION_MESSAGE);
            kosong();
            txtTransaksi.requestFocus();
            datatable();
            datatablePelanggan();
            datatablemenu();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't Save" + e, "Update", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from Transaksi where Id_Transaksi = '" + txtTransaksi.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Succes");
                kosong();
                txtTransaksi.requestFocus();
                datatable();
                datatablePelanggan();
                datatablemenu();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void tablePelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePelangganMouseClicked
        int bar = tablePelanggan.getSelectedRow();
        String a = tabmode2.getValueAt(bar, 0).toString();
        String b = tabmode2.getValueAt(bar, 1).toString();
        String c = tabmode2.getValueAt(bar, 2).toString();
        String d = tabmode2.getValueAt(bar, 3).toString();
        String e = tabmode2.getValueAt(bar, 4).toString();
        String f = tabmode2.getValueAt(bar, 5).toString();
        txtTanggal.setDate(getTanggalfromTable(tablePelanggan, 6));
        String h = tabmode2.getValueAt(bar, 7).toString();

        txtTransaksi.setText(a);
        txtNama.setText(b);
        txtNo.setText(c);
        txtEmail.setText(d);
        txtBayar.setText(e);
        txtStatus.setText(f);
    }//GEN-LAST:event_tablePelangganMouseClicked

    private void txtTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTanggalPropertyChange
        if (txtTanggal.getDate() != null) {
            SimpleDateFormat formatnya = new SimpleDateFormat("yyyy-MM-dd");
            tgl = formatnya.format(txtTanggal.getDate());
        }
    }//GEN-LAST:event_txtTanggalPropertyChange

    private void txtKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKembalianActionPerformed
        int buy = Integer.parseInt(txtBayar.getText());
        int get = Integer.parseInt(txtTotal.getText());
        int kembali = buy - get;
        txtKembalian.setText(Integer.toString(kembali));
    }//GEN-LAST:event_txtKembalianActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        String state;
        int buy = Integer.parseInt(txtBayar.getText());
        int get = Integer.parseInt(txtTotal.getText());
        if (buy >= get) {
            state = "Lunas";
            txtStatus.setText(state);
        } else {
            state = "Hutang";
            txtStatus.setText(state);
        }
    }//GEN-LAST:event_txtStatusActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        Object[] Baris = {"Id Transaksi", "Pelanggan", "No HP", "Nominal", "Status"};
        DefaultTableModel tabmode = new DefaultTableModel(null, Baris);
        tableTRANSAKSI.setModel(tabmode);
        try {
            Hashtable<Integer, String> cari1 = new Hashtable<Integer, String>();
            cari1.put(1, "Lunas");
            cari1.put(2, "Hutang");
            String sql;
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = null;

            switch (stats.getSelectedIndex()) {
                case 0:
                    sql = "SELECT * FROM detail_bon WHERE STATUS LIKE '%" + cari1.get(1) + "%'order by Id_Transaksi";
                    hasil = stat.executeQuery(sql);
                    while (hasil.next()) {
                        String Id_Transaksi = hasil.getString("Id_Transaksi");
                        String Nama = hasil.getString("Nama");
                        String Nomor = hasil.getString("Nomor");
                        String Nominal = hasil.getString("Nominal");
                        String Status = hasil.getString("Status");

                        String[] data = {Id_Transaksi, Nama, Nomor, Nominal, Status};
                        tabmode.addRow(data);
                    }
                    break;
                case 1:
                    sql = "SELECT * FROM detail_bon WHERE STATUS LIKE '%" + cari1.get(2) + "%'order by Id_Transaksi";
                    hasil = stat.executeQuery(sql);
                    while (hasil.next()) {
                        String Id_Transaksi = hasil.getString("Id_Transaksi");
                        String Nama = hasil.getString("Nama");
                        String Nomor = hasil.getString("Nomor");
                        String Nominal = hasil.getString("Nominal");
                        String Status = hasil.getString("Status");

                        String[] data = {Id_Transaksi, Nama, Nomor, Nominal, Status};
                        tabmode.addRow(data);
                    }
                    break;
            }
            tableTRANSAKSI.setModel(tabmode);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        String reportSource = null;
        String reportDest = null;
        try {
            reportSource = System.getProperty("user.dir") + "/Report/ProjectPD2.jrxml";
            reportDest = System.getProperty("user.dir") + "/Report/ProjectPD2.jasper";
            JasRep = JasperCompileManager.compileReport(reportSource);
            JasPri = JasperFillManager.fillReport(JasRep, null, conn);
            JasperExportManager.exportReportToHtmlFile(JasPri, reportDest);
            JasperViewer.viewReport(JasPri, false);
        } catch (Exception e) {
            System.out.println(e);;
        }
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton back;
    private javax.swing.JLabel bayar;
    private javax.swing.JLabel caristatus;
    private javax.swing.JButton delete;
    private javax.swing.JLabel email;
    private javax.swing.JLabel enterKembalian;
    private javax.swing.JLabel enterStatus;
    private javax.swing.JButton finish;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel kembalian;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel no;
    private javax.swing.JLabel nominal;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> stats;
    private javax.swing.JLabel status;
    private javax.swing.JTable tableMenu;
    private javax.swing.JTable tablePelanggan;
    private javax.swing.JTable tableTRANSAKSI;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel totalharga;
    private javax.swing.JLabel transaksi;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtNominal;
    private javax.swing.JTextField txtStatus;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTransaksi;
    // End of variables declaration//GEN-END:variables
}
