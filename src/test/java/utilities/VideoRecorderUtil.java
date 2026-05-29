package utilities;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorderUtil {

    private static ScreenRecorder screenRecorder;

    public static void startRecording(String testName) {

        try {

            File file = new File("./videos/");

            Dimension screenSize =
                    Toolkit.getDefaultToolkit().getScreenSize();

            Rectangle capture =
                    new Rectangle(screenSize);

            GraphicsConfiguration gc =
                    GraphicsEnvironment
                            .getLocalGraphicsEnvironment()
                            .getDefaultScreenDevice()
                            .getDefaultConfiguration();

            screenRecorder = new ScreenRecorder(
                    gc,
                    capture,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f,
                            KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                            FrameRateKey, Rational.valueOf(30)),
                    null,
                    file
            );

            screenRecorder.start();

            System.out.println("Video recording started: " + testName);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void stopRecording() {

        try {

            screenRecorder.stop();

            System.out.println("Video recording stopped");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}