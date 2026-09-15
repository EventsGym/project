package manterworkshop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import monitorarvagas.monitorarvagas_tela;

public class manterworkshop_tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;

	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtInstrutor;
	private JTextField txtData;
	private JTextField txtCarga;
	private JTextField txtVagas;
	private JTextField txtLocal;

	private JTable tableWorkshop;
	private DefaultTableModel modelo;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					manterworkshop_tela frame = new manterworkshop_tela();

					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

					frame.setVisible(true);

					frame.centralizarFormulario();

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	public manterworkshop_tela() {

		setTitle("MANTER WORKSHOP");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 900, 550);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		panel = new JPanel();

		panel.setBounds(0, 0, 900, 550);

		contentPane.add(panel);

		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("MANTER WORKSHOP");

		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));

		lblTitulo.setBounds(349, 20, 250, 35);

		panel.add(lblTitulo);

		JLabel lblCodigo = new JLabel("Código:");

		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblCodigo.setBounds(135, 75, 70, 25);

		panel.add(lblCodigo);

		txtCodigo = new JTextField();

		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtCodigo.setBounds(190, 75, 100, 25);

		panel.add(txtCodigo);

		JLabel lblTituloCampo = new JLabel("Título:");

		lblTituloCampo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTituloCampo.setBounds(320, 75, 60, 25);

		panel.add(lblTituloCampo);

		txtTitulo = new JTextField();

		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTitulo.setBounds(365, 75, 180, 25);

		panel.add(txtTitulo);

		JLabel lblVagas = new JLabel("Vagas:");

		lblVagas.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblVagas.setBounds(570, 75, 60, 25);

		panel.add(lblVagas);

		txtVagas = new JTextField();

		txtVagas.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtVagas.setBounds(620, 75, 100, 25);

		panel.add(txtVagas);

		JLabel lblInstrutor = new JLabel("Instrutor:");

		lblInstrutor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblInstrutor.setBounds(135, 115, 70, 25);

		panel.add(lblInstrutor);

		txtInstrutor = new JTextField();

		txtInstrutor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtInstrutor.setBounds(190, 115, 180, 25);

		panel.add(txtInstrutor);

		JLabel lblData = new JLabel("Data:");

		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblData.setBounds(400, 115, 50, 25);

		panel.add(lblData);

		txtData = new JTextField();

		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtData.setBounds(445, 115, 100, 25);

		panel.add(txtData);

		JLabel lblCarga = new JLabel("Carga:");

		lblCarga.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblCarga.setBounds(570, 115, 60, 25);

		panel.add(lblCarga);

		txtCarga = new JTextField();

		txtCarga.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtCarga.setBounds(620, 115, 100, 25);

		panel.add(txtCarga);

		JLabel lblLocal = new JLabel("Local:");

		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblLocal.setBounds(135, 155, 60, 25);

		panel.add(lblLocal);

		txtLocal = new JTextField();

		txtLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtLocal.setBounds(190, 155, 180, 25);

		panel.add(txtLocal);

		JButton btnNovo = new JButton("Novo");

		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnNovo.setBounds(390, 155, 100, 30);

		panel.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnSalvar.setBounds(500, 155, 100, 30);

		panel.add(btnSalvar);

		JButton btnAlterar = new JButton("Alterar");

		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnAlterar.setBounds(610, 155, 100, 30);

		panel.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");

		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnExcluir.setBounds(390, 195, 100, 30);

		panel.add(btnExcluir);

		JButton btnLimpar = new JButton("Limpar");

		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnLimpar.setBounds(500, 195, 100, 30);

		panel.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnVoltar.setBounds(610, 195, 100, 30);

		panel.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				monitorarvagas_tela monitorar = new monitorarvagas_tela();

				monitorar.setExtendedState(JFrame.MAXIMIZED_BOTH);

				monitorar.setVisible(true);

				dispose();

			}
		});

		modelo = new DefaultTableModel(

			new Object[][] {},

			new String[] {

				"Código",

				"Título",

				"Instrutor",

				"Data",

				"Carga",

				"Vagas",

				"Local"

			}

		);

		tableWorkshop = new JTable(modelo);

		tableWorkshop.setFont(new Font("Tahoma", Font.PLAIN, 13));

		tableWorkshop.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(tableWorkshop);

		scrollPane.setBounds(100, 245, 700, 240);

		panel.add(scrollPane);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

				centralizarFormulario();

			}

		});

		btnNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				limparCampos();

			}

		});

		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				modelo.addRow(new Object[] {

					txtCodigo.getText(),

					txtTitulo.getText(),

					txtInstrutor.getText(),

					txtData.getText(),

					txtCarga.getText(),

					txtVagas.getText(),

					txtLocal.getText()

				});

			}

		});

		btnAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int linha = tableWorkshop.getSelectedRow();

				if (linha >= 0) {

					modelo.setValueAt(
						txtCodigo.getText(),
						linha,
						0
					);

					modelo.setValueAt(
						txtTitulo.getText(),
						linha,
						1
					);

					modelo.setValueAt(
						txtInstrutor.getText(),
						linha,
						2
					);

					modelo.setValueAt(
						txtData.getText(),
						linha,
						3
					);

					modelo.setValueAt(
						txtCarga.getText(),
						linha,
						4
					);

					modelo.setValueAt(
						txtVagas.getText(),
						linha,
						5
					);

					modelo.setValueAt(
						txtLocal.getText(),
						linha,
						6
					);
				}
			}
		});

		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int linha = tableWorkshop.getSelectedRow();

				if (linha >= 0) {

					modelo.removeRow(linha);

				}
			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				limparCampos();

			}
		});

		tableWorkshop.getSelectionModel().addListSelectionListener(

			new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent e) {

					int linha = tableWorkshop.getSelectedRow();

					if (linha >= 0) {

						txtCodigo.setText(
							modelo.getValueAt(linha, 0).toString()
						);

						txtTitulo.setText(
							modelo.getValueAt(linha, 1).toString()
						);

						txtInstrutor.setText(
							modelo.getValueAt(linha, 2).toString()
						);

						txtData.setText(
							modelo.getValueAt(linha, 3).toString()
						);

						txtCarga.setText(
							modelo.getValueAt(linha, 4).toString()
						);

						txtVagas.setText(
							modelo.getValueAt(linha, 5).toString()
						);

						txtLocal.setText(
							modelo.getValueAt(linha, 6).toString()
						);
					}
				}
			}
		);
	}

	private void centralizarFormulario() {

		int x = (contentPane.getWidth() - panel.getWidth()) / 2;

		int y = (contentPane.getHeight() - panel.getHeight()) / 2;

		panel.setLocation(x, y);
	}

	private void limparCampos() {

		txtCodigo.setText("");

		txtTitulo.setText("");

		txtInstrutor.setText("");

		txtData.setText("");

		txtCarga.setText("");

		txtVagas.setText("");

		txtLocal.setText("");

		tableWorkshop.clearSelection();
	}
}
