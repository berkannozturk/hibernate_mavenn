package Presentation;

import java.awt.EventQueue;
import javax.persistence.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.BusinessFactory;
import Business.IBusiness;
import Model.Ogrenci;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProgramFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtAd;
	private JTextField txtSoyad;

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
		setBounds(100, 100, 450, 300);
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

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ogrenci ogrenci = new Ogrenci(txtAd.getText(), txtSoyad.getText());
				IBusiness<Ogrenci> business = BusinessFactory.getEklemeFactory();
				business.ekle(ogrenci);
				JOptionPane.showMessageDialog(btnKaydet, "Kayıt Olustu");
			}
		});
		btnKaydet.setBounds(108, 144, 89, 23);
		contentPane.add(btnKaydet);
	}
}
