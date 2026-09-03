package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class PresencaEvento extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1; 
	private JTable table;
	private JRadioButton rdbtnNewRadioButton; 
	private JRadioButton rdbtnNewRadioButton_1; 

	private static final int PANEL_WIDTH = 810;
	private static final int PANEL_HEIGHT = 570;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresencaEvento frame = new PresencaEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PresencaEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 650);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(40, 30, PANEL_WIDTH, PANEL_HEIGHT);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("CPF do Aluno:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 80, 150, 25);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(250, 78, 250, 30);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = textField_1.getText().trim();

				if (codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o código do workshop!");
					return;
				}

				verificarDisponibilidadeWorkshop(codigo, true);
			}
		});
		btnNewButton.setBounds(530, 78, 120, 30);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Cód. Workshop:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(80, 140, 150, 25);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(250, 138, 250, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);

		
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				verificarDisponibilidadeWorkshop(textField_1.getText().trim(), false);
			}

			public void removeUpdate(DocumentEvent e) {
				verificarDisponibilidadeWorkshop(textField_1.getText().trim(), false);
			}

			public void changedUpdate(DocumentEvent e) {
				verificarDisponibilidadeWorkshop(textField_1.getText().trim(), false);
			}
		});

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textField.getText().trim();
				String codigo = textField_1.getText().trim();

				if (cpf.isEmpty() || codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o CPF e o código do workshop!");
					return;
				}

				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				boolean encontrado = false;

				for (int i = 0; i < modelo.getRowCount(); i++) {
					String codigoTabela = modelo.getValueAt(i, 1).toString();

					if (codigoTabela.equals(codigo)) {
						encontrado = true;
						int vagas = Integer.parseInt(modelo.getValueAt(i, 2).toString());

						if (vagas > 0) {
							vagas--;
							modelo.setValueAt(String.valueOf(vagas), i, 2);
							JOptionPane.showMessageDialog(null, "Presença salva com sucesso!");
							verificarDisponibilidadeWorkshop(codigo, false);
						} else {
							JOptionPane.showMessageDialog(null, "Não há vagas disponíveis!");
						}
						break;
					}
				}

				if (!encontrado) {
					JOptionPane.showMessageDialog(null, "Código do workshop inválido!");
				}
			}
		});
		btnNewButton_1.setBounds(530, 138, 120, 30);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("Vagas Restantes:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(80, 430, 160, 25);
		panel.add(lblNewLabel_2);

		rdbtnNewRadioButton = new JRadioButton("Disponível");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(250, 425, 130, 30);
		rdbtnNewRadioButton.setEnabled(false);
		panel.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Indisponível");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(400, 425, 150, 30);
		rdbtnNewRadioButton_1.setEnabled(false);
		panel.add(rdbtnNewRadioButton_1);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNewRadioButton);
		grupo.add(rdbtnNewRadioButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 210, 650, 190);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(28);
		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Musculação", "1234", "30"},
				{"Pilates", "5678", "15"},
				{"Nutrição", "8971", "0"}, 
			},
			new String[] {
				"Título", "Código:", "Vagas:"
			}
		));

		
		JButton btnNewButton_3 = new JButton("Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNewButton_3.setBounds(80, 500, 140, 35);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Novo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				textField.requestFocus();
			}
		});
		btnNewButton_4.setBounds(250, 500, 140, 35);
		panel.add(btnNewButton_4);

		JButton btnFila = new JButton("Fila");
		btnFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textField.getText().trim();
				String codigo = textField_1.getText().trim();

				if (cpf.isEmpty() || codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o CPF e o código do workshop!");
					return;
				}

				int status = obterVagasWorkshop(codigo);

				if (status == -1) {
					JOptionPane.showMessageDialog(null, "Código de workshop não encontrado!");
				} else if (status > 0) {
					JOptionPane.showMessageDialog(null, "Este workshop possui vagas disponíveis. Utilize o botão 'Concluir' para confirmar a participação.");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno adicionado à fila de espera com sucesso!");
					limparCampos();
				}
			}
		});
		btnFila.setBounds(420, 500, 140, 35);
		panel.add(btnFila);

		JButton btnNewButton_2 = new JButton("Concluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textField.getText().trim();
				String codigo = textField_1.getText().trim();

				if (cpf.isEmpty() || codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o CPF e o código do workshop!");
					return;
				}

				int vagas = obterVagasWorkshop(codigo);

				if (vagas == -1) {
					JOptionPane.showMessageDialog(null, "Código do workshop não encontrado!");
				} else if (vagas == 0) {
					JOptionPane.showMessageDialog(null, "Workshop sem vagas disponíveis! Utilize o botão 'Fila' para entrar na fila de espera.");
				} else {
					JOptionPane.showMessageDialog(null, "Presença no evento concluída com sucesso!");
					limparCampos();
				}
			}
		});
		btnNewButton_2.setBounds(590, 500, 140, 35);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_3 = new JLabel("MANTER PRESENÇA NO EVENTO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(220, 20, 400, 35);
		panel.add(lblNewLabel_3);

		contentPane.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				centralizarPainel();
			}
		});

		setLocationRelativeTo(null);
		centralizarPainel();
	}

	
	private void verificarDisponibilidadeWorkshop(String codigo, boolean exibirMensagem) {
		if (codigo.isEmpty()) {
			resetarStatus();
			return;
		}

		int vagas = obterVagasWorkshop(codigo);

		if (vagas > 0) {
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton.setForeground(new Color(0, 128, 0)); 
			rdbtnNewRadioButton_1.setForeground(Color.BLACK);

			if (exibirMensagem) {
				JOptionPane.showMessageDialog(null, "Workshop encontrado!\nVagas restantes: " + vagas);
			}
		} else if (vagas == 0) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(true);
			rdbtnNewRadioButton_1.setForeground(Color.RED); 
			rdbtnNewRadioButton.setForeground(Color.BLACK);

			if (exibirMensagem) {
				JOptionPane.showMessageDialog(null, "Workshop lotado!");
			}
		} else {
			resetarStatus();
			if (exibirMensagem) {
				JOptionPane.showMessageDialog(null, "Workshop não encontrado!");
			}
		}
	}

	
	private int obterVagasWorkshop(String codigo) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for (int i = 0; i < modelo.getRowCount(); i++) {
			String codigoTabela = modelo.getValueAt(i, 1).toString();
			if (codigoTabela.equals(codigo)) {
				return Integer.parseInt(modelo.getValueAt(i, 2).toString());
			}
		}
		return -1;
	}

	private void resetarStatus() {
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
	}

	private void limparCampos() {
		textField.setText("");
		textField_1.setText("");
		resetarStatus();
	}

	private void centralizarPainel() {
		int x = (contentPane.getWidth() - PANEL_WIDTH) / 2;
		int y = (contentPane.getHeight() - PANEL_HEIGHT) / 2;

		if (x < 0) x = 0;
		if (y < 0) y = 0;

		panel.setBounds(x, y, PANEL_WIDTH, PANEL_HEIGHT);
	}
}