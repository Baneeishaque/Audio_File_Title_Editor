/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.audio_file_title_editor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author srf
 */
public class Recursive_Read_Directory {

//    public static void recursive_read_with_filter(String parent_folder, Further_Actions actions, boolean filteration, List filter) {
//
//        File folder = new File(parent_folder);
//        File files[] = folder.listFiles();
//
//        for (File file : files) {
//            if (file == null) {
//                return;
//            }
//            if (file.isHidden() || !file.canRead()) {
//                continue;
//            }
//            if (file.isDirectory()) {
//                recursive_read_with_filter(file.getPath(), actions, filteration, filter);
//            } else if (filteration) {
//                if (filter.contains(FilenameUtils.getExtension(file.getName()))) {
//                    actions.action(file.getPath() + "\\" + file.getName());
//
//                }
//            } else {
//                actions.action(file.getPath() + "\\" + file.getName());
//            }
//
//        }
//    }
    public static void recursive_read_with_filter(String parent_folder, Further_Actions actions, boolean filteration, String[] filter) {
//        recursive_read_with_filter(parent_folder, actions, filteration, Arrays.asList(filter));

        File folder = new File(parent_folder);
        File files[] = folder.listFiles();

        for (File file : files) {
            if (file == null) {
                return;
            }
            if (file.isHidden() || !file.canRead()) {
                continue;
            }
            if (file.isDirectory()) {
                recursive_read_with_filter(file.getPath(), actions, filteration, filter);
            } else if (filteration) {
                if (Arrays.stream(filter).anyMatch(FilenameUtils.getExtension(file.getName())::equals)) {
                    actions.action(file.getPath());

                }
            } else {
                actions.action(file.getPath());

            }

        }

    }

    public static void recursive_read(String parent_folder, Further_Actions actions) {
        recursive_read_with_filter(parent_folder, actions, false, new String[0]);
    }
}
