package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;

public class WebAddressToIPTranslator {
    private JLabel WebAddress;
    private JTextField textFieldWebAddress;
    private JButton findIPButton;
    private JTextField textField1;
    public JPanel test;
    private String IPaddress;

    public WebAddressToIPTranslator() {
        findIPButton.addActionListener((e)-> {

                String webAddress = textFieldWebAddress.getText().toLowerCase();
                try {
                    String IPaddress = getByName(webAddress).getHostAddress();
                    textField1.setText(IPaddress);
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }

        });
    }
    public void actionsOnButtons(){
        textFieldWebAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("on button press");
            }
        });

    }



}
