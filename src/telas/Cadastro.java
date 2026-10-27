package view;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;

	private JTextField textFieldNome;
	private JTextField textFieldUsuario;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmar;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Cadastro frame = new Cadastro();

					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

					frame.centralizarFormulario();

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public Cadastro() {

		setTitle("Cadastro");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 900, 600);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		panel = new JPanel();

		panel.setBounds(0, 0, 400, 350);

		contentPane.add(panel);

		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("CADASTRO");

		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblTitulo.setBounds(155, 20, 100, 25);

		panel.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome:");

		lblNome.setBounds(35, 70, 100, 20);

		panel.add(lblNome);

		textFieldNome = new JTextField();

		textFieldNome.setBounds(145, 70, 210, 25);

		panel.add(textFieldNome);

		JLabel lblUsuario = new JLabel("Usuário:");

		lblUsuario.setBounds(35, 110, 100, 20);

		panel.add(lblUsuario);

		textFieldUsuario = new JTextField();

		textFieldUsuario.setBounds(145, 110, 210, 25);

		panel.add(textFieldUsuario);

		JLabel lblEmail = new JLabel("E-mail:");

		lblEmail.setBounds(35, 150, 100, 20);

		panel.add(lblEmail);

		textFieldEmail = new JTextField();

		textFieldEmail.setBounds(145, 150, 210, 25);

		panel.add(textFieldEmail);

		JLabel lblSenha = new JLabel("Senha:");

		lblSenha.setBounds(35, 190, 100, 20);

		panel.add(lblSenha);

		passwordField = new JPasswordField();

		passwordField.setBounds(145, 190, 210, 25);

		panel.add(passwordField);

		JLabel lblConfirmar = new JLabel("Confirmar:");

		lblConfirmar.setBounds(35, 230, 100, 20);

		panel.add(lblConfirmar);

		passwordFieldConfirmar = new JPasswordField();

		passwordFieldConfirmar.setBounds(145, 230, 210, 25);

		panel.add(passwordFieldConfirmar);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JLogin login = new JLogin();

				login.setExtendedState(JFrame.MAXIMIZED_BOTH);
				login.setVisible(true);

				dispose();

			}

		});

		btnCadastrar.setBounds(35, 280, 130, 30);

		panel.add(btnCadastrar);

		JButton btnProximo = new JButton("Próximo");

		btnProximo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JLogin login = new JLogin();

				login.setExtendedState(JFrame.MAXIMIZED_BOTH);
				login.setVisible(true);

				dispose();

			}

		});

		btnProximo.setBounds(185, 280, 130, 30);

		panel.add(btnProximo);

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