package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ConsultaHistorico extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					ConsultaHistorico frame = new ConsultaHistorico();

					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

					frame.centralizarFormulario();

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public ConsultaHistorico() {

		setTitle("Consultar Histórico");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1000, 650);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		panel = new JPanel();

		panel.setBounds(0, 0, 900, 500);

		contentPane.add(panel);

		panel.setLayout(null);

		JLabel titulo = new JLabel("CONSULTAR HISTÓRICO DE EVENTOS", SwingConstants.CENTER);

		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));

		titulo.setBounds(250, 20, 400, 30);

		panel.add(titulo);

		JLabel lblCpf = new JLabel("CPF do Aluno:");

		lblCpf.setBounds(40, 75, 100, 25);

		panel.add(lblCpf);

		JTextField txtCpf = new JTextField();

		txtCpf.setBounds(140, 75, 180, 25);

		panel.add(txtCpf);

		JLabel lblEvento = new JLabel("Evento:");

		lblEvento.setBounds(355, 75, 70, 25);

		panel.add(lblEvento);

		JComboBox<String> cbEvento = new JComboBox<>(new String[]{
				"Todos",
				"Workshop",
				"Aula"
		});

		cbEvento.setBounds(415, 75, 150, 25);

		panel.add(cbEvento);

		JLabel lblData = new JLabel("Data:");

		lblData.setBounds(40, 115, 100, 25);

		panel.add(lblData);

		JTextField txtData = new JTextField();

		txtData.setBounds(140, 115, 180, 25);

		panel.add(txtData);

		JButton btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(415, 110, 150, 35);

		panel.add(btnBuscar);

		String[] colunas = {
				"Código",
				"Aluno",
				"CPF",
				"Evento",
				"Data",
				"Presença",
				"Status"
		};

		DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int linha, int coluna) {

				return false;

			}

		};

		JTable tabela = new JTable(modelo);

		JScrollPane scroll = new JScrollPane(tabela);

		scroll.setBounds(40, 180, 700, 230);

		panel.add(scroll);

		Object[][] dados = {
				{"2001", "Antony dos Santos Marques", "000.000.000-00", "Workshop", "10/08/2026", "Presente", "Concluído"},
				{"2002", "Iasmyn Almeida Matias", "111.111.111-11", "Aula", "11/08/2026", "Presente", "Concluído"},
				{"2003", "Jean Mendes da Silva", "222.222.222-22", "Workshop", "12/08/2026", "Ausente", "Concluído"},
				{"2004", "Maria Natália Mendonça da Silva", "333.333.333-33", "Aula", "15/08/2026", "Presente", "Concluído"},
				{"2005", "Saulo Oliveira de Araújo", "444.444.444-44", "Workshop", "20/08/2026", "Presente", "Concluído"}
		};

		for (Object[] linha : dados) {

			modelo.addRow(linha);

		}

		JButton btnVisualizar = new JButton("Visualizar");

		btnVisualizar.setBounds(760, 180, 110, 35);

		panel.add(btnVisualizar);

		JButton btnLimpar = new JButton("Limpar");

		btnLimpar.setBounds(760, 225, 110, 35);

		panel.add(btnLimpar);

		JButton btnFechar = new JButton("Fechar");

		btnFechar.setBounds(760, 270, 110, 35);

		panel.add(btnFechar);

		JLabel lblTotal = new JLabel("Registros encontrados:");

		lblTotal.setBounds(40, 440, 150, 25);

		panel.add(lblTotal);

		JTextField txtTotal = new JTextField("5");

		txtTotal.setEditable(false);

		txtTotal.setBounds(180, 440, 80, 25);

		panel.add(txtTotal);

		btnBuscar.addActionListener(e -> {

			String cpf = txtCpf.getText().replaceAll("\\D", "");
			String data = txtData.getText().trim();
			String evento = cbEvento.getSelectedItem().toString();

			if (!cpf.isEmpty() && cpf.length() != 11) {

				JOptionPane.showMessageDialog(this, "CPF inválido. Digite 11 números.");

				return;

			}

			if (!data.isEmpty()) {

				try {

					LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/uuuu"));

				} catch (DateTimeParseException erro) {

					JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/aaaa.");

					return;

				}

			}

			modelo.setRowCount(0);

			for (Object[] linha : dados) {

				String cpfRegistro = linha[2].toString().replaceAll("\\D", "");
				String eventoRegistro = linha[3].toString();
				String dataRegistro = linha[4].toString();

				boolean cpfOk = cpf.isEmpty() || cpfRegistro.equals(cpf);
				boolean dataOk = data.isEmpty() || dataRegistro.equals(data);
				boolean eventoOk = evento.equals("Todos") || eventoRegistro.equals(evento);

				if (cpfOk && dataOk && eventoOk) {

					modelo.addRow(linha);

				}

			}

			txtTotal.setText(String.valueOf(modelo.getRowCount()));

			if (modelo.getRowCount() == 0) {

				JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");

			}

		});

		btnVisualizar.addActionListener(e -> {

			int linha = tabela.getSelectedRow();

			if (linha == -1) {

				JOptionPane.showMessageDialog(this, "Selecione um registro.");

				return;

			}

			JOptionPane.showMessageDialog(
					this,
					"Aluno: " + tabela.getValueAt(linha, 1)
							+ "\nCPF: " + tabela.getValueAt(linha, 2)
							+ "\nEvento: " + tabela.getValueAt(linha, 3)
							+ "\nData: " + tabela.getValueAt(linha, 4)
							+ "\nPresença: " + tabela.getValueAt(linha, 5)
							+ "\nStatus: " + tabela.getValueAt(linha, 6)
			);

		});

		btnLimpar.addActionListener(e -> {

			txtCpf.setText("");
			txtData.setText("");
			cbEvento.setSelectedIndex(0);
			tabela.clearSelection();

			modelo.setRowCount(0);

			for (Object[] linha : dados) {

				modelo.addRow(linha);

			}

			txtTotal.setText(String.valueOf(modelo.getRowCount()));

		});

		btnFechar.addActionListener(e -> dispose());

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

				centralizarFormulario();

			}

		});

	}

	private void centralizarFormulario() {

		int x = (contentPane.getWidth() - panel.getWidth()) / 2;

		int y = (contentPane.getHeight() - panel.getHeight()) / 2;

		panel.setLocation(x, y);

	}

}
