package Presentation;

import java.awt.EventQueue;
import javax.persistence.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Business.BusinessFactory;
import Business.IBusiness;
import Model.Ogrenci;

import Repository.IRepository;
import Repository.OgrenciRepository;
import Repository.RepositoryFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JTable;

public class ProgramFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTable table;

	IRepository<Ogrenci> ogrenciListesi = RepositoryFactory.getOgrenciRepository();

	List<Ogrenci> ogrenciler;
	Ogrenci o = new Ogrenci();

	public void ogrencileriListele() {
		ogrenciler = ogrenciListesi.Listele(o);

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Id");
		model.addColumn("Ad");
		model.addColumn("Soyad");

		Object[] row = new Object[3];

		int size = ogrenciler.size();

		for (int i = 0; i < size; i++) {
			row[0] = ogrenciler.get(i).getId();
			row[1] = ogrenciler.get(i).getAd();
			row[2] = ogrenciler.get(i).getSoyad();

			model.addRow(row);
		}
		table.setModel(model);
	}

	// int secilenSatir = table.getSelectedRow();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramFrame frame = new ProgramFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProgramFrame() {

		setTitle("Ogrenci Kayit Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(24, 41, 46, 14);
		contentPane.add(lblNewLabel);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(108, 38, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblAd = new JLabel("Ad");
		lblAd.setBounds(24, 69, 46, 14);
		contentPane.add(lblAd);

		txtAd = new JTextField();
		txtAd.setColumns(10);
		txtAd.setBounds(108, 66, 86, 20);
		contentPane.add(txtAd);

		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(24, 103, 46, 14);
		contentPane.add(lblSoyad);

		txtSoyad = new JTextField();
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(108, 100, 86, 20);
		contentPane.add(txtSoyad);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 414, 279);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(table);

		JButton btnKaytsec = new JButton("Kayıt Seç");
		btnKaytsec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilenSatir = table.getSelectedRow();
				if (secilenSatir > -1) {
					Ogrenci secilenOgrenci = ogrenciler.get(secilenSatir);
					txtId.setText(String.valueOf(secilenOgrenci.getId()));
					txtAd.setText(secilenOgrenci.getAd());
					txtSoyad.setText(secilenOgrenci.getSoyad());
				} else {
					JOptionPane.showMessageDialog(scrollPane, "bir kayıt seçiniz");
				}

			}

		});
		btnKaytsec.setBounds(212, 144, 89, 23);
		contentPane.add(btnKaytsec);
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtId.getText().length() == 0) {
					Ogrenci ogrenci = new Ogrenci(txtAd.getText(), txtSoyad.getText());
					IBusiness<Ogrenci> business = BusinessFactory.getBusinessFactory();
					business.ekle(ogrenci);
					JOptionPane.showMessageDialog(btnKaydet, "Kayıt Olustu");
					ogrencileriListele();
				} else {
					int ogrenci_id = Integer.valueOf(table.getSelectedRow());
					Ogrenci secilenOgrenci = ogrenciler.get(ogrenci_id);
					secilenOgrenci.setId(Integer.valueOf(txtId.getText()));
					secilenOgrenci.setAd(txtAd.getText());
					secilenOgrenci.setSoyad(txtSoyad.getText());

					IBusiness<Ogrenci> business = BusinessFactory.getBusinessFactory();
					business.guncelle(secilenOgrenci, ogrenci_id);
					JOptionPane.showMessageDialog(btnKaydet, "Kayıt güncellendi");
					ogrencileriListele();
				}
				ogrencileriListele();
			}
		});
		btnKaydet.setBounds(108, 144, 89, 23);
		contentPane.add(btnKaydet);

		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int secilenSatir = table.getSelectedRow();
				if (secilenSatir > -1) {
					Ogrenci secilenOgrenci = ogrenciler.get(secilenSatir);
					IBusiness<Ogrenci> business = BusinessFactory.getBusinessFactory();
					business.sil(secilenOgrenci, secilenOgrenci.getId());
					ogrencileriListele();
				} else {
					JOptionPane.showMessageDialog(scrollPane, "Kayıt Seciniz");
				}
			}
		});
		btnSil.setBounds(321, 144, 89, 23);
		contentPane.add(btnSil);
		ogrencileriListele();
	}
}
