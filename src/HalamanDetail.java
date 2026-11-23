import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class HalamanDetail extends JPanel {
    private final Main mainFrame;
    private final JLabel labelCover;
    private final JLabel labelJudul;
    private final JLabel labelGenre;
    private final JLabel labelRating;
    private final JTextArea areaSinopsis;

    public HalamanDetail(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout(20, 20));
        setBackground(Theme.BG);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        labelCover = new JLabel();
        labelCover.setVerticalAlignment(SwingConstants.TOP);
        add(labelCover, BorderLayout.WEST);

        JPanel info = new JPanel(new BorderLayout(0, 12));
        info.setOpaque(false);

        JPanel header = new JPanel(new GridLayout(3, 1, 0, 4));
        header.setOpaque(false);

        labelJudul = new JLabel("-");
        labelJudul.setFont(Theme.JUDUL);
        labelJudul.setForeground(Theme.PUTIH);

        labelGenre = new JLabel("-");
        labelGenre.setFont(Theme.NORMAL);
        labelGenre.setForeground(Theme.ABU);

        labelRating = new JLabel("-");
        labelRating.setFont(Theme.SUBJUDUL);
        labelRating.setForeground(Theme.AKSEN);

        header.add(labelJudul);
        header.add(labelGenre);
        header.add(labelRating);
        info.add(header, BorderLayout.NORTH);

        areaSinopsis = new JTextArea();
        areaSinopsis.setFont(Theme.NORMAL);
        areaSinopsis.setForeground(Theme.PUTIH);
        areaSinopsis.setOpaque(false);
        areaSinopsis.setEditable(false);
        areaSinopsis.setLineWrap(true);
        areaSinopsis.setWrapStyleWord(true);
        info.add(areaSinopsis, BorderLayout.CENTER);

        add(info, BorderLayout.CENTER);

        JPanel bawah = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        bawah.setOpaque(false);

        JButton btnKembali = new JButton("Kembali ke Daftar");
        btnKembali.setFont(Theme.TOMBOL);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.bukaHalaman("Komik");
            }
        });

        JButton btnBaca = new JButton("Baca Chapter Terbaru");
        btnBaca.setFont(Theme.TOMBOL);
        btnBaca.setBackground(Theme.AKSEN);
        btnBaca.setForeground(Theme.HITAM);
        btnBaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Membuka " + labelRating.getText().split("· ")[1]
                        + " dari " + labelJudul.getText());
            }
        });

        bawah.add(btnKembali);
        bawah.add(btnBaca);
        add(bawah, BorderLayout.SOUTH);
    }

    public void setKomik(int index) {
        labelCover.setIcon(Main.ambilGambar(Main.GAMBAR[index], 200, 280));
        labelJudul.setText(Main.JUDUL[index]);
        labelGenre.setText(Main.GENRE[index]);
        labelRating.setText("★ " + Main.RATING[index] + " · " + Main.CHAPTER[index]);
        areaSinopsis.setText(Main.SINOPSIS[index]);
    }
}