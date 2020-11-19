package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.DataAccessException;
import controllayer.ProductController;
import controllayer.SaleOrderController;
import modellayer.Product;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBarcode;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lbpostnrLabel;
	private JLabel lblBylabel;
	private JLabel lblTelefonLabel;
	private JPanel panel;
	private JTextField searchField;
	private JLabel lblProductAmount;
	private JLabel lblProductPrice;
	private JLabel lblTotalPrice;
	private JButton btnConfirm;
	private JButton btnAnullerOrdre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setBounds(28, 58, 162, 28);
		contentPane.add(textFieldBarcode);
		textFieldBarcode.setColumns(10);
		
		JLabel barcodeLabel = new JLabel("Stregkode:");
		barcodeLabel.setBounds(28, 43, 73, 14);
		contentPane.add(barcodeLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Navn");
		textField.setBounds(28, 141, 162, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 189, 162, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Navn");
		textField_2.setColumns(10);
		textField_2.setBounds(28, 242, 162, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Navn");
		textField_3.setColumns(10);
		textField_3.setBounds(28, 295, 162, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Navn");
		textField_4.setColumns(10);
		textField_4.setBounds(28, 349, 162, 28);
		contentPane.add(textField_4);
		
		JLabel lblNavnlabel = new JLabel("Navn");
		lblNavnlabel.setBounds(28, 127, 73, 14);
		contentPane.add(lblNavnlabel);
		
		JLabel lblAdresselabel = new JLabel("Adresse");
		lblAdresselabel.setBounds(28, 175, 73, 14);
		contentPane.add(lblAdresselabel);
		
		lbpostnrLabel = new JLabel("Postnr");
		lbpostnrLabel.setBounds(28, 228, 73, 14);
		contentPane.add(lbpostnrLabel);
		
		lblBylabel = new JLabel("By");
		lblBylabel.setBounds(28, 281, 73, 14);
		contentPane.add(lblBylabel);
		
		lblTelefonLabel = new JLabel("Telefon");
		lblTelefonLabel.setBounds(28, 334, 73, 14);
		contentPane.add(lblTelefonLabel);
		
		panel = new JPanel();
		panel.setBounds(347, 58, 697, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel productlbl = new JLabel("Produkt:");
		productlbl.setBounds(10, 11, 46, 14);
		panel.add(productlbl);
		
		JLabel lblAntal = new JLabel("Antal:");
		lblAntal.setBounds(343, 11, 46, 14);
		panel.add(lblAntal);
		
		JLabel lblPris = new JLabel("Pris:");
		lblPris.setBounds(516, 11, 46, 14);
		panel.add(lblPris);
		
		JLabel lblFjern = new JLabel("Fjern");
		lblFjern.setBounds(641, 11, 46, 14);
		panel.add(lblFjern);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(680, 0, 17, 397);
		panel.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 36, 323, 14);
		panel.add(lblNewLabel);
		
		lblProductAmount = new JLabel("");
		lblProductAmount.setBounds(343, 36, 156, 14);
		panel.add(lblProductAmount);
		
		lblProductPrice = new JLabel("");
		lblProductPrice.setBounds(516, 36, 120, 14);
		panel.add(lblProductPrice);
		
		searchField = new JTextField();
		searchField.setBounds(347, 24, 190, 30);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton btnSearch = new JButton("S\u00F8g Vare");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					findProduct();
				} catch (NumberFormatException | DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBackground(new Color(100, 149, 237));
		btnSearch.setBounds(539, 23, 100, 30);
		contentPane.add(btnSearch);
		
		lblTotalPrice = new JLabel("Total Pris:           Kr.");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalPrice.setVerticalAlignment(SwingConstants.TOP);
		lblTotalPrice.setBounds(347, 466, 148, 28);
		contentPane.add(lblTotalPrice);
		
		btnConfirm = new JButton("Betal");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.setBounds(606, 466, 120, 39);
		contentPane.add(btnConfirm);
		
		btnAnullerOrdre = new JButton("Anuller ordre");
		btnAnullerOrdre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnullerOrdre.setBackground(new Color(255, 0, 0));
		btnAnullerOrdre.setBounds(732, 466, 120, 39);
		contentPane.add(btnAnullerOrdre);
	}
	
	private void findProduct() throws DataAccessException  {
		if(searchField.getText().isEmpty()) {
			System.out.println("Skriv et navn i feltet");
			
		}else{
			Product p = ProductController.findProductByName(searchField.getText());
			if(p == null) {
				System.out.println("LORTE PROGRAM");
				System.out.println(searchField.getText());
			}else {
				System.out.println(p);
				System.out.println(searchField.getText());
			}

			System.out.println(searchField.getText());
		}

		

	}
}
