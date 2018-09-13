import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {
    private JTextArea chatArea;
    private JTextField msgField;
    private JButton sendButton;

    public Chat(int width, int height) {
        super("Chat client");
        constructChat(width, height);
    }

    private void constructChat(int width, int height) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        //решил использовать BL компоновщик
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());

        //экран чата
        JPanel textPanel = new JPanel();
        chatArea = new JTextArea();
        chatArea.setLineWrap(true);
        JScrollPane scroll = new JScrollPane (chatArea);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textPanel.setLayout(new BorderLayout());
        getContentPane().add(scroll);
        textPanel.add(scroll);
        textPanel.setBorder(new EmptyBorder(10,10,10,10));
        chatPanel.add(textPanel, BorderLayout.CENTER);

        //Поле ввода сообщения и кнопка отправки
        msgField = new JTextField(20);
        sendButton = new JButton("Send");
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(0,10,10,10));
        bottomPanel.add(msgField);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        chatPanel.add(bottomPanel, BorderLayout.PAGE_END);

        chatArea.setEditable(false);

        //изменить цвета для лучше наглядности
        paintChat();

        //обработчики эвентов клавы и кнопки
        addListeners();

        setContentPane(chatPanel);
        setVisible(true);
    }

    private void paintChat() {
        chatArea.setBackground(Color.YELLOW);
        msgField.setBackground(Color.GREEN);
        sendButton.setBackground(Color.CYAN);
    }

    private void addListeners() {
        ActionListener sendListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSendAction();
            }
        };
        sendButton.addActionListener(sendListener);
        msgField.addActionListener(sendListener);
    }

    private void performSendAction() {
        if (msgField.getText().length() == 0)
            return;

        chatArea.append("> " + msgField.getText() + "\n");
        msgField.setText("");
        msgField.grabFocus();
    }
}
