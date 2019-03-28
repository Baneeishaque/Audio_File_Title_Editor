/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.audio_file_title_editor;

/**
 *
 * @author srf
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Jaudiotagger_utils.read_title("Under Attack.mp3");
        Further_Actions action = (String full_file_path) -> {
//            System.out.println(full_file_path);
            Jaudiotagger_utils.read_title(full_file_path);
        };

        Recursive_Read_Directory.recursive_read_with_filter("D:\\DK-HP-PA-2000AR\\Songs", action, true, new String[]{"aac", "ape", "flac", "m4a", "mp3", "wma"});

    }

}
