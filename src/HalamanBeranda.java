import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class HalamanBeranda extends JPanel {
    private final Main mainFrame;

    public HalamanBeranda(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout(0, 20));
        setBackground(Theme.BG);
        setBorder(new EmptyBorder(15, 20, 20, 20));

        add(new JLabel(Main.ambilGambar("banner.png", 840, 200), SwingConstants.CENTER),
                BorderLayout.NORTH);

        JPanel bawah = new JPanel(new BorderLayout(0, 12));
        bawah.setOpaque(false);

        JLabel judul = new JLabel("Rekomendasi");
        judul.setFont(Theme.JUDUL);
        judul.setForeground(Theme.AKSEN);
        bawah.add(judul, BorderLayout.NORTH);

        JPanel daftar = new JPanel(new GridLayout(1, 4, 15, 15));
        daftar.setOpaque(false);
        for (int i = 0; i < 4; i++) {
            daftar.add(buatKartu(i));
        }
        bawah.add(daftar, BorderLayout.CENTER);

        add(bawah, BorderLayout.CENTER);
    }

    private JPanel buatKartu(int index) {
        JPanel kartu = new JPanel(new BorderLayout(0, 6));
        kartu.setOpaque(false);

        kartu.add(new JLabel(Main.ambilGambar(Main.GAMBAR[index], 180, 200)),
                BorderLayout.NORTH);

        JPanel info = new JPanel(new GridLayout(2, 1));
        info.setOpaque(false);

        JLabel labelJudul = new JLabel(Main.JUDUL[index]);
        labelJudul.setFont(Theme.SUBJUDUL);
        labelJudul.setForeground(Theme.PUTIH);

        JLabel labelRating = new JLabel("★ " + Main.RATING[index] + " · " + Main.CHAPTER[index]);
        labelRating.setFont(Theme.NORMAL);
        labelRating.setForeground(Theme.ABU);

        info.add(labelJudul);
        info.add(labelRating);
        kartu.add(info, BorderLayout.CENTER);

        // Event Adapter Class: override mouseClicked
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