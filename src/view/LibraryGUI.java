package view;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI extends JFrame {

    public JTextField bookIdField, bookTitleField, memberIdField, memberNameField, searchField;
    public JTextArea outputArea;
    public JButton addBookBtn, viewBooksBtn, issueBookBtn, returnBookBtn,
                    addMemberBtn, viewMembersBtn, searchBtn, issuedBtn, availableBtn;
    public JToggleButton darkToggle;

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Library Management System", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 28));
        add(header, BorderLayout.NORTH);

        JPanel left = new JPanel(new GridLayout(11, 2, 10, 10));
        left.setBorder(BorderFactory.createTitledBorder("Controls"));

        bookIdField = new JTextField();
        bookTitleField = new JTextField();
        memberIdField = new JTextField();
        memberNameField = new JTextField();
        searchField = new JTextField();

        addBookBtn = new JButton("Add Book");
        viewBooksBtn = new JButton("View Books");
        issueBookBtn = new JButton("Issue Book");
        returnBookBtn = new JButton("Return Book");
        addMemberBtn = new JButton("Add Member");
        viewMembersBtn = new JButton("View Members");
        searchBtn = new JButton("Search");
        issuedBtn = new JButton("Issued");
        availableBtn = new JButton("Available");
        darkToggle = new JToggleButton("Dark Mode");

        left.add(new JLabel("Book ID")); left.add(bookIdField);
        left.add(new JLabel("Book Title")); left.add(bookTitleField);
        left.add(addBookBtn); left.add(viewBooksBtn);
        left.add(issueBookBtn); left.add(returnBookBtn);
        left.add(new JLabel("Member ID")); left.add(memberIdField);
        left.add(new JLabel("Member Name")); left.add(memberNameField);
        left.add(addMemberBtn); left.add(viewMembersBtn);
        left.add(new JLabel("Search Book")); left.add(searchField);
        left.add(searchBtn); left.add(darkToggle);
        left.add(issuedBtn); left.add(availableBtn);

        add(left, BorderLayout.WEST);

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }
}
