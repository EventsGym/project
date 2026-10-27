package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Map;
import java.util.HashMap;
import javax.swing.SwingConstants;

public class JFila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JComboBox<String> comboBox;
	private JCheckBox chckbxNewCheckBox;
	private JTable table;
	private DefaultTableModel modeloFila;
	private static final int PANEL_WIDTH = 810;
	private static final int PANEL_HEIGHT = 570;
	private Map<String, Integer> capacidadeMaxima;
	private Map<String, Integer> vagasOcupadas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFila frame = new JFila();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(0, 0, 900, 650);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		capacidadeMaxima = new HashMap<String, Integer>();
		capacidadeMaxima.put("Musculação", 2);
		capacidadeMaxima.put("Pilates", 2);
		capacidadeMaxima.put("Nutrição", 2);

		vagasOcupadas = new HashMap<String, Integer>();
		vagasOcupadas.put("Musculação", 2);
		vagasOcupadas.put("Pilates", 2);
		vagasOcupadas.put("Nutrição", 2);

		panel = new JPanel();
		panel.setBounds(40, 30, PANEL_WIDTH, PANEL_HEIGHT);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Fila de Espera");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, PANEL_WIDTH, 50);
		panel.add(lblTitulo);

		JLabel lblNewLabel = new JLabel("Digite o nome do aluno(a)");
		lblNewLabel.setBounds(80, 80, 250, 16);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(80, 100, 480, 28);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String aluno = textField.getText().trim();

				if (aluno.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Digite o nome do aluno para pesquisar!");
					return;
				}

				boolean encontrado = false;

				for (int i = 0; i < modeloFila.getRowCount(); i++) {
					String alunoTabela = modeloFila.getValueAt(i, 1).toString();
					if (alunoTabela.equalsIgnoreCase(aluno)) {
						encontrado = true;
						JOptionPane.showMessageDialog(null,
								"Aluno já está na fila de espera!\n"
								+ "Posição: " + modeloFila.getValueAt(i, 0));
						break;
					}
				}

				if (!encontrado) {
					JOptionPane.showMessageDialog(null,
							"Aluno não encontrado na fila de espera.\n"
							+ "Preencha o evento e confirme a inserção.");
				}
			}
		});
		btnPesquisar.setBounds(580, 100, 150, 28);
		panel.add(btnPesquisar);

		JLabel lblNewLabel_1 = new JLabel("Evento");
		lblNewLabel_1.setBounds(80, 150, 200, 16);
		panel.add(lblNewLabel_1);

		comboBox = new JComboBox<String>();
		comboBox.addItem("Musculação");
		comboBox.addItem("Pilates");
		comboBox.addItem("Nutrição");
		comboBox.setBounds(80, 170, 650, 28);
		panel.add(comboBox);

		chckbxNewCheckBox = new JCheckBox("Inserir aluno na lista de espera ");
		chckbxNewCheckBox.setBounds(80, 220, 350, 28);
		panel.add(chckbxNewCheckBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 260, 650, 220);
		panel.add(scrollPane);

		modeloFila = new DefaultTableModel(
			new Object[][] {},
			new String[] { "Posição", "Aluno(a)", "Evento" }
		) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(modeloFila);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(22);
		scrollPane.setViewportView(table);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				comboBox.setSelectedIndex(0);
				chckbxNewCheckBox.setSelected(false);
				textField.requestFocus();
			}
		});
		btnLimpar.setBounds(80, 510, 180, 35);
		panel.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PresencaEvento presenca = new PresencaEvento();

				presenca.setExtendedState(JFrame.MAXIMIZED_BOTH);

				presenca.setVisible(true);

				dispose();

			}
		});
		btnVoltar.setBounds(315, 510, 180, 35);
		panel.add(btnVoltar);

		JButton btnNewButton = new JButton("Salvar Cadastro");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String aluno = textField.getText().trim();
				Object evento = comboBox.getSelectedItem();

				if (aluno.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Digite o nome do aluno!");
					return;
				}

				if (evento == null) {
					JOptionPane.showMessageDialog(null,
							"Selecione um evento!");
					return;
				}

				int capacidade = capacidadeMaxima.get(evento.toString());
				int ocupadas = vagasOcupadas.get(evento.toString());

				if (ocupadas < capacidade) {
					JOptionPane.showMessageDialog(null,
							"Este evento ainda possui vagas disponíveis!\n"
							+ "Não é necessário inserir o aluno na fila "
							+ "de espera.");
					return;
				}

				if (!chckbxNewCheckBox.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"Marque a opção \"Inserir aluno na lista de "
							+ "espera\" para confirmar a inclusão!");
					return;
				}

				for (int i = 0; i < modeloFila.getRowCount(); i++) {
					String alunoTabela = modeloFila.getValueAt(i, 1).toString();
					String eventoTabela = modeloFila.getValueAt(i, 2).toString();
					if (alunoTabela.equalsIgnoreCase(aluno)
							&& eventoTabela.equalsIgnoreCase(evento.toString())) {
						JOptionPane.showMessageDialog(null,
								"Este aluno já está na fila de espera "
								+ "deste evento!");
						return;
					}
				}

				int posicao = 1;
				for (int i = 0; i < modeloFila.getRowCount(); i++) {
					String eventoTabela = modeloFila.getValueAt(i, 2).toString();
					if (eventoTabela.equalsIgnoreCase(evento.toString())) {
						posicao++;
					}
				}

				modeloFila.addRow(new Object[] { posicao, aluno, evento });

				JOptionPane.showMessageDialog(null,
						"Aluno inserido na fila de espera!\n"
						+ "Evento: " + evento + "\n"
						+ "Posição: " + posicao);

				textField.setText("");
				comboBox.setSelectedIndex(0);
				chckbxNewCheckBox.setSelected(false);
				textField.requestFocus();
			}
		});
		btnNewButton.setBounds(550, 510, 180, 35);
		panel.add(btnNewButton);

		contentPane.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				centralizarPainel();
			}
		});

		setLocationRelativeTo(null);
		centralizarPainel();
	}

	private void centralizarPainel() {
		int x = (contentPane.getWidth() - PANEL_WIDTH) / 2;
		int y = (contentPane.getHeight() - PANEL_HEIGHT) / 2;

		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}

		panel.setBounds(x, y, PANEL_WIDTH, PANEL_HEIGHT);
	}
}
