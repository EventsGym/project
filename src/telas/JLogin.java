package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Conexao;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					JLogin frame = new JLogin();

					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

					frame.centralizarFormulario();

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public JLogin() {

		setTitle("Sistema de Login");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 900, 600);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		panel = new JPanel();

		panel.setBounds(0, 0, 533, 414);

		contentPane.add(panel);

		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("SISTEMA DE LOGIN");

		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblTitulo.setBounds(183, 24, 180, 25);

		panel.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuário:");

		lblUsuario.setBounds(35, 70, 70, 20);

		panel.add(lblUsuario);

		textFieldUsuario = new JTextField();

		textFieldUsuario.setBounds(105, 70, 368, 25);

		panel.add(textFieldUsuario);

		JLabel lblSenha = new JLabel("Senha:");

		lblSenha.setBounds(35, 110, 70, 20);

		panel.add(lblSenha);

		passwordField = new JPasswordField();

		passwordField.setBounds(105, 110, 368, 25);

		panel.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				realizarLogin();

			}

		});

		btnEntrar.setBounds(137, 160, 100, 25);

		panel.add(btnEntrar);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				abrirCadastro();

			}

		});

		btnCadastrar.setBounds(300, 160, 110, 25);

		panel.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");

		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				textFieldUsuario.setText("");

				passwordField.setText("");

				textFieldUsuario.requestFocus();

			}

		});

		btnLimpar.setBounds(137, 196, 100, 25);

		panel.add(btnLimpar);

		JButton btnSair = new JButton("Sair");

		btnSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}

		});

		btnSair.setBounds(300, 196, 110, 25);

		panel.add(btnSair);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

				centralizarFormulario();

			}

		});

	}

	private void realizarLogin() {

		String usuario = textFieldUsuario.getText().trim();

		String senha = new String(passwordField.getPassword()).trim();

		if (usuario.isEmpty() || senha.isEmpty()) {

			JOptionPane.showMessageDialog(null,
					"Preencha todos os campos!");

			return;

		}

		String sql = "SELECT * FROM usuarios "
				+ "WHERE usuario = ? AND senha = ?";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement comando =
					conexao.prepareStatement(sql);

			comando.setString(1, usuario);

			comando.setString(2, senha);

			ResultSet resultado =
					comando.executeQuery();

			if (resultado.next()) {

				JOptionPane.showMessageDialog(null,
						"Login realizado com sucesso!");

				monitorarvagas_tela monitorar =
						new monitorarvagas_tela();

				monitorar.setExtendedState(
						JFrame.MAXIMIZED_BOTH);

				monitorar.setVisible(true);

				dispose();

			} else {

				int resposta =
						JOptionPane.showConfirmDialog(
								null,
								"Usuário não cadastrado ou senha incorreta!\n"
										+ "Deseja realizar um cadastro?",
								"Acesso bloqueado",
								JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					abrirCadastro();

				}

			}

			resultado.close();

			comando.close();

			conexao.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao realizar login: "
							+ e.getMessage());

		}

	}

	private void abrirCadastro() {

		Cadastro cadastro = new Cadastro();

		cadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);

		cadastro.setVisible(true);

		dispose();

	}

	private void centralizarFormulario() {

		int x = (contentPane.getWidth() - panel.getWidth()) / 2;

		int y = (contentPane.getHeight() - panel.getHeight()) / 2;

		panel.setLocation(x, y);

	}

}