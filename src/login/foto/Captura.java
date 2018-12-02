/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.foto;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_core.Size;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author root
 *
public class Captura {

    /*public static Mat detecta() {
        OpenCVFrameConverter.ToMat convertMat = new OpenCVFrameConverter.ToMat();
        OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);
        KeyEvent tecla = null;
        opencv_objdetect.CascadeClassifier detector = new opencv_objdetect.CascadeClassifier("/home/tallys/teste/TechFin/src/login/foto/haarcascade-frontalface-alt.xml");
        Mat faceDetectada = null;

        cFrame = new CanvasFrame("Cadastrar uma foto - \\(ESPAÇO\\)", CanvasFrame.getDefaultGamma() / camera.getGamma());
        

        try {
            camera.start();
            Mat colorida = new Mat();
            Frame frame = null;

            while ((frame = camera.grab()) != null) {
                colorida = convertMat.convert(frame);
                Mat cinza = new Mat();
                opencv_imgproc.cvtColor(colorida, cinza, opencv_imgproc.COLOR_BGRA2GRAY);

                RectVector face = new opencv_core.RectVector();
                detector.detectMultiScale(cinza, face, 1.1, 1, 0, new Size(150, 150), new Size(500, 500));

                for (int i = 0; i < face.size(); i++) {
                    Rect dadosFace = face.get(0);
                    System.out.println(dadosFace.area());
                    opencv_imgproc.rectangle(colorida, dadosFace, new Scalar(0, 0, 255, 0));
                    faceDetectada = new Mat(cinza, dadosFace);
                    opencv_imgproc.resize(faceDetectada, faceDetectada, new Size(160, 160));

                    cFrame.showImage(frame);

                }

                cFrame.dispose();
                camera.stop();

                return faceDetectada;

            }
        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
        }
*/