package Note;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
 * Java Swing GUI for taking notes
 */
public class NoteWindow {
    private static JFrame frame;
    private static File filename;

    public static void main(String[] args){
        frame = new JFrame("Discrete");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        NotePanel panel = new NotePanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(new Dimension(700, 650));
        frame.setMinimumSize(new Dimension(525, 490));
        frame.setVisible(true);
    }




    /*
     * Panel that holds text and buttons
     */
    public static class NotePanel extends JPanel {
        GridBagConstraints c;
        JButton AND, INF, LESS, MORE, NOT, OR, XOR, UNION, INTERSECTION, SUBSET, SUBSETOREQUAL, NOTSUBSET, EXISTS, FORALL, THEREFORE, ELEMENT, CONTAINS, EQUIVALENT;

        JTextArea noteSpace;
        JMenuItem save;

        


        private NotePanel() {


            JMenuBar mb = new JMenuBar();
            JMenu menu = new JMenu("Menu");
            save = new JMenuItem("Save");
            JMenuItem saveAs = new JMenuItem("Save As");
            save.setEnabled(false);
            JMenuItem load = new JMenuItem("Load");
            menu.add(save);
            menu.add(saveAs);
            menu.add(load);
            mb.add(menu);
            frame.setJMenuBar(mb);

            setLayout(new GridBagLayout());
            c = new GridBagConstraints();
            c.insets = new Insets(10, 10, 10, 10);
            c.fill = GridBagConstraints.NONE;

            AND = new JButton("\u22C0");
            OR = new JButton("\u22C1");
            NOT = new JButton("\u00AC");
            XOR = new JButton("\u2295");
            UNION = new JButton("\u22C3");
            INTERSECTION = new JButton("\u22C2");
            SUBSET = new JButton("\u2282");
            SUBSETOREQUAL = new JButton("\u2286");
            NOTSUBSET = new JButton("\u2284");
            INF = new JButton("\u221E");
            FORALL = new JButton("\u2200");
            EXISTS = new JButton("\u2203");
            THEREFORE = new JButton("\u2234");
            EQUIVALENT = new JButton("\u2261");
            ELEMENT = new JButton("\u2208");
            CONTAINS = new JButton("\u220B");
            LESS = new JButton("\u2264");
            MORE = new JButton("\u2265");


            noteSpace = new JTextArea("");
            noteSpace.setMargin(new Insets(10,10,10,10));
            JScrollPane scroll = new JScrollPane(noteSpace);
            noteSpace.setLineWrap(true);


            c.anchor = GridBagConstraints.FIRST_LINE_START;

            c.gridx = 0;
            c.gridy = 0;
            add(AND, c);
            c.gridy=1;
            add(NOT,c);
            c.gridy = 2;
            add(INTERSECTION, c);
            c.gridy=3;
            add(SUBSET,c);
            c.gridy=4;
            add(NOTSUBSET,c);
            c.gridy=5;
            add(FORALL,c);
            c.gridy=6;
            add(ELEMENT,c);
            c.gridy=7;
            add(THEREFORE,c);
            c.gridy=8;
            add(LESS,c);

            c.gridx = 1;
            c.gridy = 0;
            add(OR, c);
            c.gridy=1;
            add(XOR,c);
            c.gridy = 2;
            add(UNION, c);
            c.gridy=3;
            add(SUBSETOREQUAL,c);
            c.gridy=4;
            add(INF,c);
            c.gridy=5;
            add(EXISTS,c);
            c.gridy=6;
            add(CONTAINS,c);
            c.gridy=7;
            add(EQUIVALENT,c);
            c.gridy=8;
            add(MORE,c);

            c.fill = GridBagConstraints.BOTH;
            c.weightx=7.0;
            c.weighty=1.0;
            c.gridheight= 9;
            c.gridx=3;
            c.gridy=0;
            add(scroll,c);


            AND.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u22C0" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });


            OR.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u22C1" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            INF.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u221E" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            LESS.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2264" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            MORE.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2265" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            NOT.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u00AC" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            XOR.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2295" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            UNION.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u22C3" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            INTERSECTION.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u22C2" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            SUBSET.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2282" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            SUBSETOREQUAL.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2286" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();
            });

            NOTSUBSET.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2284" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            EXISTS.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2203" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            FORALL.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2200" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            THEREFORE.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2234" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            ELEMENT.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2208" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            CONTAINS.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u220B" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            EQUIVALENT.addActionListener(e -> {
                trySave();
                int caret = noteSpace.getCaretPosition();
                String t = noteSpace.getText().substring(0, caret) + "\u2261" + noteSpace.getText().substring(caret);
                noteSpace.setText(t);
                noteSpace.setCaretPosition(caret+1);
                noteSpace.requestFocus();

            });

            load.addActionListener(e -> {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                chooser.setFileFilter(filter);
                if(chooser.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
                    filename = chooser.getSelectedFile();
                    save.setEnabled(true);
                    try {
                        FileReader fr  = new FileReader(filename);
                        int i;
                        StringBuilder x= new StringBuilder();
                        while ((i=fr.read()) != -1)
                            x.append((char) i);

                        noteSpace.setText(x.toString());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }




            });

            noteSpace.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    trySave();
                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });

            save.addActionListener(e -> {
                    try {
                        String s = noteSpace.getText();
                        PrintWriter writer = new PrintWriter(filename);
                        writer.print(s);
                        writer.close();
                        save.setEnabled(false);

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }

            });

            saveAs.addActionListener(e -> {
                String s = noteSpace.getText();
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                chooser.setFileFilter(filter);

                chooser.setCurrentDirectory(new File("~/"));
                int retrival = chooser.showSaveDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    try {
                        PrintWriter writer = new PrintWriter(chooser.getSelectedFile()+".txt");
                        writer.print(s);
                        writer.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });







        }
        /*
         * Anytime a button is clicked or a key is pressed, the program will check 
         * if it can enable the save button from the menu
         */
        private void trySave(){
                try{
                    FileInputStream fis = new FileInputStream(filename);
                    fis.close();
                    save.setEnabled(true);
                }catch (Exception e) {
                    save.setEnabled(false);
                }
        }
    }
}
