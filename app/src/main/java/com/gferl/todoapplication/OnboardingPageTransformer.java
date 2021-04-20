package com.gferl.todoapplication;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class OnboardingPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {

        // Dapatkan indeks halaman dari tag
        // mungkin untuk mengetahui indeks halaman
        // saat ini berubah - dan bisa digunakan
        // untuk membuat beberapa peningkatan kinerja yang penting.
        int pagePosition = (int) page.getTag();

        // Di sini dapat melakukan segala macam hal, seperti mendapatkan
        // lebar halaman dan melakukan perhitungan berdasarkan
        // seberapa jauh pengguna telah menggesek halaman.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Sekarang waktunya untuk efeknya
        if (position <= -1.0f || position >= 1.0f) {

            // Halaman tidak terlihat. Ini tempat yang bagus untuk berhenti
            // pekerjaan / animasi potensial yang mungkin sedang Anda jalankan.

        } else if (position == 0.0f) {

            // Halaman ini dipilih. Ini saat yang tepat untuk mengatur ulang Tampilan
            // setelah animasi karena Anda tidak selalu dapat mengandalkan PageTransformer
            // panggilan balik untuk dicocokkan dengan sempurna.

        } else {

            // Halaman saat ini sedang di-scroll / digesek. Ini adalah
            // tempat yang bagus untuk menampilkan animasi yang bereaksi terhadap pengguna
            // menggesek karena memberikan pengalaman pengguna yang baik.

            // Mari kita mulai dengan menganimasikan judul.
            // Kami ingin memudar saat bergulir keluar
            View title = page.findViewById(R.id.textView7);
            title.setAlpha(1.0f - absPosition);

            // Sekarang deskripsinya. Kami juga ingin yang ini
            // memudar, tetapi animasi juga harus bergerak perlahan
            // turun dan keluar dari layar
            View description = page.findViewById(R.id.textView8);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);


            // Sekarang, kami ingin gambar bergerak ke kanan,
            // yaitu dalam arah berlawanan dari file
            // konten sambil memudar
            View computer = page.findViewById(R.id.imageView3);

            // Kami mencoba membuat efek untuk Tampilan
            // khusus untuk salah satu halaman di ViewPager kami.
            // Dengan kata lain, kita perlu memastikan bahwa kita aktif
            // halaman yang benar dan tampilan yang dimaksud
            // bukan null.
            if (computer != null) {
                computer.setAlpha(1.0f - absPosition);
                computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
//                computer.setTranslationY(-pageWidthTimesPosition / 2f);
            }


            // Akhirnya, akan berguna untuk mengetahui arahnya
            // gesekan pengguna - jika kita masuk atau keluar.
            // Ini cukup sederhana:
            if (position < 0) {
                // Buat animasi disini
            } else {
                // Buat animasi disini
            }
        }
    }

}
