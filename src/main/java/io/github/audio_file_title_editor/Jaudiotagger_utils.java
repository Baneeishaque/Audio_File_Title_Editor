/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.audio_file_title_editor;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

/**
 *
 * @author srf
 */
public class Jaudiotagger_utils {

    public static void read_title(String file_path) {
        System.out.println("File is : " + file_path);
        AudioFile f;
        try {
            f = AudioFileIO.read(new File(file_path));
            Tag tag = f.getTag();
            System.out.println("Title is : " + tag.getFirst(FieldKey.TITLE));
        } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
            Logger.getLogger(Jaudiotagger_utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
