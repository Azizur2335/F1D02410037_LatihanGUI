import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class HalamanKomik extends JPanel {
    private final Main mainFrame;

    public HalamanKomik(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout(0, 15));
        setBackground(Theme.BG);
        setBorder(new EmptyBorder(15, 20, 20, 20));

        JPanel atas = new JPanel(new BorderLayout(0, 10));
        atas.setOpaque(false);

        JLabel judul = new JLabel("Daftar Komik");
        judul.setFont(Theme.JUDUL);
        judul.setForeground(Theme.PUTIH);

        JTextField kolomCari = new JTextField("Cari judul manga...");
        kolomCari.setFont(Theme.NORMAL);
        kolomCari.setBackground(Theme.KARTU);
        kolomCari.setForeground(Theme.ABU);
        kolomCari.setCaretColor(Theme.PUTIH);
        kolomCari.setBorder(new EmptyBorder(8, 10, 8, 10));

        atas.add(judul, BorderLayout.NORTH);
        atas.add(kolomCari, BorderLayout.CENTER);
        add(atas, BorderLayout.NORTH);

        JPanel daftar = new JPanel(new GridLayout(2, 2, 15, 15));
        daftar.setOpaque(false);
        for (int i = 0; i < Main.JUDUL.length; i++) {
            daftar.add(buatKartu(i));
        }

        JScrollPane scroll = new JScrollPane(daftar);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(Theme.BG);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
    }

    private JPanel buatKartu(int index) {
        JPanel kartu = new JPanel(new BorderLayout(12, 0));
        kartu.setBackground(Theme.KARTU);
        kartu.setBorder(new EmptyBorder(12, 12, 12, 12));

        kartu.add(new JLabel(Main.ambilGambar(Main.GAMBAR[index], 90, 130)), BorderLayout.WEST);

        JPanel info = new JPanel(new GridLayout(3, 1, 0, 4));
        info.setOpaque(false);

        JLabel labelJudul = new JLabel(Main.JUDUL[index]);
        labelJudul.setFont(Theme.SUBJUDUL);
        labelJudul.setForeground(Theme.PUTIH);

        JLabel labelGenre = new JLabel(Main.GENRE[index]);
        labelGenre.setFont(Theme.NORMAL);
        labelGenre.setForeground(Theme.ABU);

        JLabel labelRating = new JLabel("★ " + Main.RATING[index] + " · " + Main.CHAPTER[index]);
        labelRating.setFont(Theme.NORMAL);
        labelRating.setForeground(Theme.AKSEN);

        info.add(labelJudul);
        info.add(labelGenre);
        info.add(labelRating);
        kartu.add(info, BorderLayout.CENTER);

        kartu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        kartu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.bukaDetail(index);
            }
        });

        return kartu;
    }
}