package speechtotext;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

public class SpeechtoText_main {

	  public static void main(String[] args) {
		    SpeechToText service = new SpeechToText();
		    service.setUsernameAndPassword("16041982-0fe5-4a39-9fd1-8b468e6e0a74", "eWLukIxzkwsk");

		    File audio = new File("audio/sample1.wav");
		    RecognizeOptions options = null;
		    try{
		    	options = new RecognizeOptions.Builder()
		    			.model("ja-JP_BroadbandModel")
		    			.audio(audio)
		    			.contentType(RecognizeOptions.ContentType.AUDIO_WAV)
		    			.build();
		    } catch (FileNotFoundException e) {
		    	e.printStackTrace();
		    }
		    SpeechRecognitionResults transcript = service.recognize(options).execute();

		    System.out.println(transcript);
		  }

}
