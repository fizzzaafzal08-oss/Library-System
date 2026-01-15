package controller;

import view.LibraryGUI;
import java.io.*;
import java.util.*;
import java.awt.*;

public class LibraryController {

    private LibraryGUI gui;

    public LibraryController(LibraryGUI gui) {
        this.gui = gui;

        gui.addBookBtn.addActionListener(e -> addBook());
        gui.viewBooksBtn.addActionListener(e -> viewBooks());
        gui.issueBookBtn.addActionListener(e -> updateBook(true));
        gui.returnBookBtn.addActionListener(e -> updateBook(false));
        gui.addMemberBtn.addActionListener(e -> addMember());
        gui.viewMembersBtn.addActionListener(e -> viewMembers());
        gui.searchBtn.addActionListener(e -> searchBook());
        gui.issuedBtn.addActionListener(e -> filter(true));
        gui.availableBtn.addActionListener(e -> filter(false));
        gui.darkToggle.addActionListener(e -> darkMode());
    }

    private void addBook() {
        try {
            FileWriter fw = new FileWriter("data/books.txt", true);
            fw.write(gui.bookIdField.getText() + "," +
                     gui.bookTitleField.getText() + ",false\n");
            fw.close();
            gui.outputArea.setText("Book added successfully.");
        } catch (Exception e) {
            gui.outputArea.setText("Error adding book.");
        }
    }

    private void viewBooks() {
        readFile("data/books.txt");
    }

    private void updateBook(boolean issue) {
        try {
            List<String> list = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("data/books.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(gui.bookIdField.getText()))
                    d[2] = String.valueOf(issue);
                list.add(String.join(",", d));
            }
            br.close();
            FileWriter fw = new FileWriter("data/books.txt");
            for (String l : list) fw.write(l + "\n");
            fw.close();
            gui.outputArea.setText("Book status updated.");
        } catch (Exception e) {
            gui.outputArea.setText("Error updating book.");
        }
    }

    private void addMember() {
        try {
            FileWriter fw = new FileWriter("data/members.txt", true);
            fw.write(gui.memberIdField.getText() + "," +
                     gui.memberNameField.getText() + "\n");
            fw.close();
            gui.outputArea.setText("Member added.");
        } catch (Exception e) {
            gui.outputArea.setText("Error adding member.");
        }
    }

    private void viewMembers() {
        readFile("data/members.txt");
    }

    private void searchBook() {
        search(gui.searchField.getText());
    }

    private void filter(boolean issued) {
        gui.outputArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader("data/books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith(String.valueOf(issued)))
                    gui.outputArea.append(line + "\n");
            }
        } catch (Exception e) {}
    }

    private void darkMode() {
        Color bg = gui.darkToggle.isSelected() ? new Color(30,30,30) : Color.WHITE;
        Color fg = gui.darkToggle.isSelected() ? Color.WHITE : Color.BLACK;
        gui.getContentPane().setBackground(bg);
        gui.outputArea.setBackground(bg);
        gui.outputArea.setForeground(fg);
    }

    private void readFile(String path) {
        gui.outputArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                gui.outputArea.append(line + "\n");
        } catch (Exception e) {}
    }

    private void search(String key) {
        gui.outputArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader("data/books.txt"))) {
            String line;
            while ((line = br.readLine()) != null)
                if (line.toLowerCase().contains(key.toLowerCase()))
                    gui.outputArea.append(line + "\n");
        } catch (Exception e) {}
    }
}
