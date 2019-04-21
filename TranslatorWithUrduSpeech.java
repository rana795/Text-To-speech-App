package com.gilo.TrnaslatorWithUrduSpeech;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.gilo.TranslatorWithUrduSpeech.R;
import com.memetix.mst.detect.Detect;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;


public class TranslatorWithUrduSpeech extends Activity implements OnInitListener{

	Language[] languages = Language.values();
	private TextToSpeech tts;
	
	TextView  textTranslated;
	EditText userText;
	ProgressBar loading;
	View vs;
	@SuppressWarnings("static-access")
	protected void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.main_page);
		
		tts = new TextToSpeech(this, this);
		
		
		Trans();
		Sound();
		Locale loc = new Locale("en");
		Log.i("-------------",Arrays.toString(loc.getAvailableLocales()));
	}
	
	
	public void showInvalidInputDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Error In The Input Text");
		
		builder.setMessage("Please Enter the Text again!");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}
	
	
	public void showEmptyDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Input is Empty");
		
		builder.setMessage("Please Enter the Text !");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}
	
	
	public void showEmptyTranslationDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Translation is Empty");
		
		builder.setMessage("Please Do The Translation First !");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}

	
	public void Sound() 
	{
		
	
		final ImageButton bt=(ImageButton)findViewById(R.id.imageButton1);
		

		
		textTranslated = (TextView) findViewById(R.id.textview1);
		
		
		
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
                 
			          
	            ///For empty   
				if(textTranslated.getText().length()==0 )
				{
					showEmptyTranslationDialog();
					userText.getText().clear();
					
				}
				
					class bgStuff extends AsyncTask<Void, Void, Void>{
						
						String translatedTexts = "";
						
							
						@Override
						protected void onPreExecute() {
						
							super.onPreExecute();
						}

						
						@Override
						protected Void doInBackground(Void... params) {
						
							try {
								
								translatedTexts = translation();
								
								/*
								if(text2[m]!='\u0627")||text2[m]!='\u0622")||text2[m]!='\u0628")||text2[m]!='\u067E")||text2[m]!='\u062A")||text2[m]!='\u0679")||text2[m]!='\u062B")||text2[m]!='\u062C")||text2[m]!='\u0686")||text2[m]!='\u062D")||text2[m]!='\u062E")||text2[m]!='\u062F")||text2[m]!='\u0688")||text2[m]!='\u0630")||text2[m]!='\u0631")||text2[m]!='\u0691")||text2[m]!='\u0632")||
										
										text2[m]!='\u0698")||text2[m]!='\u0633")||text2[m]!='\u0634")||text2[m]!='\u0635")||text2[m]!='\u0636")||text2[m]!='\u0637")||text2[m]!='\u0638")||text2[m]!='\u0639")||text2[m]!='\u063A")||text2[m]!='\u0641")||text2[m]!='\u0642")||text2[m]!='\u06A9")||text2[m]!='\u06AF")||text2[m]!='\u0644")||text2[m]!='\u0645")||text2[m]!='\u0646")||text2[m]!='\u06BA")
										
										||text2[m]!='\u0648")||text2[m]!='\u0624")||text2[m]!='\u06C1")||text2[m]!='\u06BE")||text2[m]!='\u0620")||text2[m]!='\u06CC")||text2[m]!='\u064A")||text2[m]!='\u06D2")||text2[m]!='\u06D3")||text2[m]!='\u0020"))
										{
									      
											userText.getText().clear();
									     
										}
								*/
								
							}  catch (Exception e) {
								translatedTexts = "Unable to translate";
							}
							return null;
						}

						@Override
						protected void onPostExecute(Void result) {
							
						
							super.onPostExecute(result);
						}
						
					}
					
					new bgStuff().execute();
			}
		});
		
		
		
		

	
	
			
		
	
	
		
   }
		
		

	public void Trans(){
				
		textTranslated = (TextView) findViewById(R.id.textview1);
		
		
		
		userText = (EditText) findViewById(R.id.editText3);
	
		final Button b=(Button)findViewById(R.id.button1);
		
	
		
		
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			     
                ///For empty  
				if(userText.getText().length()==0 )
				{
					showEmptyDialog();
				}
				
				
				//For Numbers
				if(userText.getText().toString().contains("0")||userText.getText().toString().contains("1")||userText.getText().toString().contains("2")||userText.getText().toString().contains("3")||userText.getText().toString().contains("4")||userText.getText().toString().contains("5")||userText.getText().toString().contains("6")||userText.getText().toString().contains("7")||userText.getText().toString().contains("8")||userText.getText().toString().contains("9"))
				{
					showInvalidInputDialog();
					userText.getText().clear();
					
				}
			
				
				/*
				//For end spaces
				if(userText.getText().toString().endsWith(" "))
				{
					showInvalidInputDialog();
					userText.getText().clear();
				
				}
				*/
				
				//For special symbols
			
				
				if(userText.getText().toString().contains("~")||userText.getText().toString().contains("!")||userText.getText().toString().contains("#")||userText.getText().toString().contains("$")||userText.getText().toString().contains("%")||userText.getText().toString().contains("^")||userText.getText().toString().contains("&")||userText.getText().toString().contains("*")||userText.getText().toString().contains("(")||userText.getText().toString().contains(")")
						
						||userText.getText().toString().contains("_")||userText.getText().toString().contains("-")||userText.getText().toString().contains("+")||userText.getText().toString().contains("=")||userText.getText().toString().contains("/")||userText.getText().toString().contains("|")||userText.getText().toString().contains(">")||userText.getText().toString().contains("<")||userText.getText().toString().contains("?")||userText.getText().toString().contains("`")||userText.getText().toString().contains("{")||userText.getText().toString().contains("}")
						
						||userText.getText().toString().contains("[")||userText.getText().toString().contains("]")||userText.getText().toString().contains(".")||userText.getText().toString().contains(","))
				{
					showInvalidInputDialog();
					userText.getText().clear();
					
				}
				
					
					class bgStuff extends AsyncTask<Void, Void, Void>{
						
						String translatedText = "";
						
							
						@Override
						protected void onPreExecute() {
							
							super.onPreExecute();
						}

						
						@Override
						protected Void doInBackground(Void... params) {
							
							try {
								
								
								translatedText = translateText();
								
								
								///FOR INVALID
								
								/*
								
								if(!translatedText.contains("\u0627")||!translatedText.contains("\u0622")||!translatedText.contains("\u0628")||!translatedText.contains("\u067E")||!translatedText.contains("\u062A")||!translatedText.contains("\u0679")||!translatedText.contains("\u062B")||!translatedText.contains("\u062C")||!translatedText.contains("\u0686")||!translatedText.contains("\u062D")||!translatedText.contains("\u062E")||!translatedText.contains("\u062F")||!translatedText.contains("\u0688")||!translatedText.contains("\u0630")||!translatedText.contains("\u0631")||!translatedText.contains("\u0691")||!translatedText.contains("\u0632")||
										
								!translatedText.contains("\u0698")||!translatedText.contains("\u0633")||!translatedText.contains("\u0634")||!translatedText.contains("\u0635")||!translatedText.contains("\u0636")||!translatedText.contains("\u0637")||!translatedText.contains("\u0638")||!translatedText.contains("\u0639")||!translatedText.contains("\u063A")||!translatedText.contains("\u0641")||!translatedText.contains("\u0642")||!translatedText.contains("\u06A9")||!translatedText.contains("\u06AF")||!translatedText.contains("\u0644")||!translatedText.contains("\u0645")||!translatedText.contains("\u0646")||!translatedText.contains("\u06BA")
								
								||!translatedText.contains("\u0648")||!translatedText.contains("\u0624")||!translatedText.contains("\u06C1")||!translatedText.contains("\u06BE")||!translatedText.contains("\u0620")||!translatedText.contains("\u06CC")||!translatedText.contains("\u064A")||!translatedText.contains("\u06D2")||!translatedText.contains("\u06D3")||!translatedText.contains("\u0020")||!translatedText.contains(".")||!translatedText.contains(","))
								{
									
									//translatedText = "INVALID CHARACTERS";
									//showInvalidInputDialog();
									userText.getText().clear();
									
								}
								*/
								
							} catch (Exception e) {
								
								
								translatedText = "Unable to translate";
							}
							return null;
						}

						@Override
						protected void onPostExecute(Void result) {
							
						
							
							
							
						
							
						//	textEntered.setText(userText.getText().toString());
							textTranslated.setText(translatedText);
							
							///INVALID LOGIC HERE WORKS
							/*
							
							if(!(textTranslated.getText().toString().contains("\u0627")||textTranslated.getText().toString().contains("\u0622")||textTranslated.getText().toString().contains("\u0628")||textTranslated.getText().toString().contains("\u067E")||textTranslated.getText().toString().contains("\u062A")||textTranslated.getText().toString().contains("\u0679")||textTranslated.getText().toString().contains("\u062B")||textTranslated.getText().toString().contains("\u062C")||textTranslated.getText().toString().contains("\u0686")||textTranslated.getText().toString().contains("\u062D")||textTranslated.getText().toString().contains("\u062E")||textTranslated.getText().toString().contains("\u062F")||textTranslated.getText().toString().contains("\u0688")||textTranslated.getText().toString().contains("\u0630")||textTranslated.getText().toString().contains("\u0631")||textTranslated.getText().toString().contains("\u0691")||textTranslated.getText().toString().contains("\u0632")||
									
									textTranslated.getText().toString().contains("\u0698")||textTranslated.getText().toString().contains("\u0633")||textTranslated.getText().toString().contains("\u0634")||textTranslated.getText().toString().contains("\u0635")||textTranslated.getText().toString().contains("\u0636")||textTranslated.getText().toString().contains("\u0637")||textTranslated.getText().toString().contains("\u0638")||textTranslated.getText().toString().contains("\u0639")||textTranslated.getText().toString().contains("\u063A")||textTranslated.getText().toString().contains("\u0641")||textTranslated.getText().toString().contains("\u0642")||textTranslated.getText().toString().contains("\u06A9")||textTranslated.getText().toString().contains("\u06AF")||textTranslated.getText().toString().contains("\u0644")||textTranslated.getText().toString().contains("\u0645")||textTranslated.getText().toString().contains("\u0646")||textTranslated.getText().toString().contains("\u06BA")
									
									||textTranslated.getText().toString().contains("\u0648")||textTranslated.getText().toString().contains("\u0624")||textTranslated.getText().toString().contains("\u06C1")||textTranslated.getText().toString().contains("\u06BE")||textTranslated.getText().toString().contains("\u0620")||textTranslated.getText().toString().contains("\u06CC")||textTranslated.getText().toString().contains("\u064A")||textTranslated.getText().toString().contains("\u06D2")||textTranslated.getText().toString().contains("\u06D3")||textTranslated.getText().toString().contains("\u0020")||textTranslated.getText().toString().contains(".")||textTranslated.getText().toString().contains(",")))
														
							
							{

								showInvalidInputDialog();
						        textTranslated.setText("Invalid characters IN The Text");
						       
							}
						*/
							
						
							super.onPostExecute(result);
						}
						
					}
					
					new bgStuff().execute();
			}
		});
		
				
		
	}
	
String detectedLanguage = "";
	
	public String translateText() throws Exception{
		
	       Translate.setClientId("malikgapp1");
	       Translate.setClientSecret("malikgheavybike01234"); 
	       
	       //String translatedText = Translate.execute(userText.getText().toString(),languages[EnterLan.getSelectedItemPosition()], languages[TransLan.getSelectedItemPosition()]);
		   
	        String translatedText="";
	        
	       translatedText=Translate.execute(userText.getText().toString(),Language.URDU);
	       
	       Language detectedLanguage = Detect.execute(userText.getText().toString());
	       this.detectedLanguage = detectedLanguage.getName(Language.ENGLISH);
	       
	    	   
	    	   return translatedText;
	      
           //SpeakText(translatedText);
	       //playSound();
			
	}
	/*
	public String[] GetAllValues()
	{
		String lan[] = new String[languages.length];
		for(int i = 0; i < languages.length; i++){
			lan[i] = languages[i].name();
		}
		
		return lan;
	}
	
	public void playSound(){
		MediaPlayer player = new MediaPlayer();
		try {
			player.setVolume(10, 10);
			player.setDataSource("http://api.microsofttranslator.com/V2/http.svc/Speak?appId=Bearer+http%253a%252f%252fschemas.xmlsoap.org%252fws%252f2005%252f05%252fidentity%252fclaims%252fnameidentifier%3dgilokimu%26http%253a%252f%252fschemas.microsoft.com%252faccesscontrolservice%252f2010%252f07%252fclaims%252fidentityprovider%3dhttps%253a%252f%252fdatamarket.accesscontrol.windows.net%252f%26Audience%3dhttp%253a%252f%252fapi.microsofttranslator.com%26ExpiresOn%3d1360142778%26Issuer%3dhttps%253a%252f%252fdatamarket.accesscontrol.windows.net%252f%26HMACSHA256%3dBzK2I18ZSFu0lkV88oCNZUDZzt9QwmVaaDLQKyhhpjs%253d&text=Did+you+enjoy+the+2011+Cricket+World+Cup%3f&language=en-");
			player.start();
		
		} catch (IllegalArgumentException e)
		{
			
			e.printStackTrace();
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		} catch (SecurityException e) {
			
			e.printStackTrace();
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		} catch (IllegalStateException e) 
		{
			
			e.printStackTrace();
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		} catch (IOException e) 
		{
			e.printStackTrace();
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
		
	}
*/	
	
	///Translation function
	public String translation() throws Exception 
	{
		   Translate.setClientId("malikgapp1");
	       Translate.setClientSecret("malikgheavybike01234"); 
	         
	        String translatedText="";
	        
	       translatedText=Translate.execute(userText.getText().toString(),Language.URDU);
	       
	       Language detectedLanguage = Detect.execute(userText.getText().toString());
	       this.detectedLanguage = detectedLanguage.getName(Language.ENGLISH);
	      
           SpeakText(translatedText);
	       //playSound();
			return translatedText;
		
	}
	
	
	
	
	
	
	///SPEAK TEXT FUNCTION
	public void SpeakText(String text)
	{
	
		
		/*
	   tts.setSpeechRate((float) 0.6);
	   tts.setPitch((float)1.2);
	   tts.speak("MERA NAAM", TextToSpeech.QUEUE_ADD, null);
		*/
		
		//cheking issue
		
		
		/*
		int jo=text.length();
		jo=jo-1;
		char text2[]=text.toCharArray();
		int i;
		
		tts.setSpeechRate((float) 0.4);

		for(i=0;i<=jo;i++)
		{
		
			if(text2[i]=='\u002E')
			{
				tts.speak("Stop", TextToSpeech.QUEUE_ADD, null);
			
			}
			
			if(text2[i]=='.')
			{
				tts.speak("dot", TextToSpeech.QUEUE_ADD, null);
			
			}
			
			if(text2[i]=='\u002D')
			{
				tts.speak("dash", TextToSpeech.QUEUE_ADD, null);
			
				
			}
			
			if(text2[i]=='\u002C')
			{
				tts.speak("comma", TextToSpeech.QUEUE_ADD, null);
			
				
			}
			if(text2[i]==',')
			{
				tts.speak("english comma", TextToSpeech.QUEUE_ADD, null);
			
				
			}
			*/
			
			
			/*
		if(text2[i]=='\u06BA')
		{
			tts.speak("Noon GUNNA", TextToSpeech.QUEUE_ADD, null);
		
		}
		
		///OK
		
		
		if(text2[i]=='\u06D2')
		{
			tts.speak("BARI YEH", TextToSpeech.QUEUE_ADD, null);
		
		}
		
		///OK
		
		if(text2[i]=='\u0624')
		{
			tts.speak("WAO WITH HAMZA", TextToSpeech.QUEUE_ADD, null);
		
		}
		if(text2[i]=='\u0691')
		{
			tts.speak("AR REY", TextToSpeech.QUEUE_ADD, null);
		
		}
		
		///OK
		if(text2[i]=='\u06BE')
		{
			tts.speak("ANKHO WALI HEY", TextToSpeech.QUEUE_ADD, null);
		
		}
		
		
		if(text2[i]=='\u06CC')
		{
			tts.speak("CHOTI YEH", TextToSpeech.QUEUE_ADD, null);
		
		}
		
		///with nukto & with choti yeh
		
		if(text2[i]=='\u064A')
		{
			tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
		
		}
		
	}
*/	
	
	
		
		tts.setSpeechRate((float) 0.4);
		//tts.setPitch((float)1.2);
		int jo=text.length();
		jo=jo-1;
		char text2[]=text.toCharArray();
		int ct=1;
		int i=0,j=1,m=0;
		int count=0;
		
	
	
		
		do{
		 	
		/////////////////////alifff//////////////
			if(text2[i]=='\u0627')
			{ 
				 
				
				count=count+1;
				
				
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF 
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
			

					tts.speak("ab", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("UP", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("ut", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("AAH", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("ed", TextToSpeech.QUEUE_ADD, null);
					 
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("az", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("AR", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("az", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("as", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("AUS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("ek", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("AL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("Um", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
					
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("AN", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("AH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("ek", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
				if(text2[j]=='\u064A')
				{
					tts.speak("ek", TextToSpeech.QUEUE_ADD, null);
				
				}
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				
				
				if(jo==count)
				{
					
					
					ct=8;
					break;
				}
				else
				{
					m=m+1;
				
				}

			
			}
			
			
			///For space
			if(text2[m]=='\u0020')
			{
				m=m+1;
			
				count=count+1;
				//Thread.sleep(100);
				//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
				//Thread.sleep(100);
				
			
			}
			
			/*
		
			///For dot
			if(text2[m]=='\u002E')
			{
				m=m+1;
			
				count=count+1;
				//Thread.sleep(100);
				//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
				//Thread.sleep(100);
				
			
			}	
			*/
			
		
			
			///////////////////////nooonnnn/////////
			
			if(text2[m]=='\u0646')
			{
				
				count=count+1;
				j=m+1;
			

				//tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Naa", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("NEES", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("NEES", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("Nah", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("NE", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("NAY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			///////////////////////////////alif madaaaa//////
			
			if(text2[m]=='\u0622')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("UP", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("ahhaj", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("um", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
			
	///////////////////////////////baayyyy
			
			
			if(text2[m]=='\u0628')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ba", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("bath", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("BUD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("BIS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("BILL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("BEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("Beer", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	////////////////////////////////ppppppppppppppaaaaaaaaaaaaaaaaaayyyyyyyyyyyyyyyyyyyyyy
			if(text2[m]=='\u067E')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Pa", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("PER", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("PER", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("PUN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("P U", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
//////////////////////////////////////////////////////////tttttttttaaaayyyyyyyyyy
			if(text2[m]=='\u062A')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("TA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("Taab", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("tuz", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("TUR", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("tuz", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("TA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("TUM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
		///////////////////////////////////////////ttttttTTTTTaayyyyy//////////
			if(text2[m]=='\u0679')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ta", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("Tur", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("Tea", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	//////////////////////////////////sssssaaaaayyyyyyyy////////////////////
			
			if(text2[m]=='\u062B')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Sa", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("SUL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	//////////////////////////jjjeeeeeeeeemmmmmmmmmmmmmm////////////
			
			if(text2[m]=='\u062C')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("JEED", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("JER", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("JIM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("Jay", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	/////////////////////////////////////ccccccchhhhhhhhhaaaaaayyyyyyyyyyyy
			if(text2[m]=='\u0686')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("CHA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("CHU", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	////////////////////hhhhhhhaaaaaaaaaayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy
			
			if(text2[m]=='\u062D')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("HA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("HUB", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("hath", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("hus", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("HUM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
/////////////////////////////////kkkkkkkkhaaaaaaaaaaaaaaaaaaaaayyyyyyyy
			
			if(text2[m]=='\u062E')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ha", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("KHAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
		////////////////dddddddddaaaaaaaaaaaaaaaaaallllllllllllllllll
			
			if(text2[m]=='\u062F')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("DA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("DIG", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("DIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("Though", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	/////////////////////ddddddadddddaaaaddddaaaaaaaaaaaaalllllllllllllllllllll
			if(text2[m]=='\u0688')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Da", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
	
			
	/////////////////////////////zzzzzzzzzallllllllllllllllll
			
			if(text2[m]=='\u0630')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("za", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("za", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
		
	/////////////////////////rrrrrrraaaaaaaaayyyyyyyyyyyyyyyy
			if(text2[m]=='\u0631')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ra", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("RUD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("RUS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("RISH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("RICK", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("RUM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("RO", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("RAH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("RE", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("RAY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	///////////////aaarrrrrraeeeeeeeeyyyyyyyyyyyyyyyyyyyyyyyyyyyy
			if(text2[m]=='\u0691')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ra", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	//////////////////////////////2222222222222zzzzzzzzzayyyyyyyyyyyyyyyy
			if(text2[m]=='\u0632')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("za", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("ZIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("za", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	//////////////////////////////222222222sssssssssayyyyyyy
			
			if(text2[m]=='\u0698')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("sa", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
			
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
///////////////////////////sssssaaaaaaaaaaeeeeeeeeeeeeeeeennnnnnnnnnn
			
			if(text2[m]=='\u0633')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("sa", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("SIR", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("Sa", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("sum", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("Say", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	////////////////////////////sssssssssshhhhhhhaaaaaaaaeeeeeeeeeennnnnnnnn
			
			if(text2[m]=='\u0634')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Sha", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("Shab", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHISH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("SHAQ", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
	//////////////////////////sssssssssooooooooooooaaaaaaaaaaddddddd
			
			if(text2[m]=='\u0635')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("Say", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("SUD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("SUL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	//////////////zzzzzzzzzzzzooooooooooooooaaaaaaaaaaddddddddddddddddddddd
			
			if(text2[m]=='\u0636')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("ZUR", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	/////////////////////////////ttttttttttooooooooooooooooaaaaaaainnnnn
			
			if(text2[m]=='\u0637')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ta", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
//////////////////////////zzzzzzzzzzzzoaiiiiiiiinnnnnnnnnnnnnnnnnnn
			
			if(text2[m]=='\u0638')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("Z", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	///////////////////////////aaaaaaaaaaaaaaaeeeeeeeiniiiiiiiiiinnnnnnnnnnnnnn
			if(text2[m]=='\u0639')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ah", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("ED", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("is", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("ILL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	///////////////ggggggghhhhhhhhhhaaaaaaaaaaaaaiiiiiiiiiiiinnnnnnnnnnnnnnnnn
			if(text2[m]=='\u063A')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("Gyer", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	/////////////////////////ffffffffffayyyyyyyyyyyyyyyyyyyyyyyyyyy
			if(text2[m]=='\u0641')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	/////////////////kkkkkkkkkaaaaaaaaaaaaaafffffffffffffffnnnoootttooonnnnnn
			if(text2[m]=='\u0642')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ka", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("KUS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			//////////////////kkkkkkaaaaaaaaafffffffffddddddaaannnnnnnnnd
			if(text2[m]=='\u06A9')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ka", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("KIT", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("KIT", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("KER", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("KISS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("KIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("KAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("Kam", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("KO", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("kah", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("Kai", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("KI", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("Kes", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("Kay", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
	////////////////////////ggggggggggaaaaaaaaaaaffffffffffff
			
			if(text2[m]=='\u06AF')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("GUL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("Ghee", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	/////////////////////////lllllllllllllllaaaaaaaaaaaaaaaammmmmmmmmm
			
			if(text2[m]=='\u0644')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("la", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("Lib", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("LUS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("LUCK", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("LUM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("LAW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("LEE", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
		////////////////////mmmmmmmmmmmmmmmeeeeeeeeeeeeeeemmmmmmmmmm
			
			if(text2[m]=='\u0645')
			{
				
				
				count=count+1;
				j=m+1;
			

				//tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ma", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("Muth", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("Mus", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("Mooj", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("Moo", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("MUD", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("MAR", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("MAS", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("MUK", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("MUL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("MUN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("MO", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("MAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("MAY", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			//06BE
////////////////////////dddddooooaaaakhonnnn waliii haeeeyyyyyy
			
			if(text2[m]=='\u06BE')
			{
				
				
				count=count+1;
				j=m+1;
			

				//tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("Ha", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("HATH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("MUD", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("MUK", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("MUN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("MAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("MAYY", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		///////////////////////nnnnnnnnnonnnnnnnnnnngggghhhhhooooonnnnaaa
			if(text2[m]=='\u06BA')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
/////////////////////////////////wwwwaaaaaaaaooooooooooooooo
			
			
			if(text2[m]=='\u0648')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("were", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("OSH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("OF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Waka", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	////////////////waooooooooohhhamzzaaa
			if(text2[m]=='\u0624')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	/////////////////////hhhhhhhhhheeeeeeeeeeeeyyyyyyyyyy
			if(text2[m]=='\u06C1')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ha", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("HATH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("HER", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("HUM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("HO", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("HE", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(200);
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			


			
///////////HAMZA//////////////////////////////
					
		if(text2[m]=='\u0620')
		{
		
		count=count+1;
		j=m+1;
		
		
		//tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
		///ALIF MADDA
		
		///TODAY-->AJ OK
		
		if(text2[j]=='\u0622')
		{
			
		
			tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///ALIF
		
		/// ASAD-->ok
		if(text2[j]=='\u0627')
		{
			
			
		
			tts.speak("YA", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		
		///BAY 
		///sheep ok
		
		if(text2[j]=='\u0628')
		{
			
		
			tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///PAY
		
		///captured --> PAR OK
		
		if(text2[j]=='\u067E')
		{
			
		
			tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///TAY 
		///Parrot-->totay OK
		if(text2[j]=='\u062A')
		{
			
		
			tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//TTAY
		///TOMATOE--> OK
		if(text2[j]=='\u0679')
		{
			
		
			tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//SAY  VERIFied
		
		///SAMAR->OK
		if(text2[j]=='\u062B')
		{
			
		
			tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		//JEEM
		//Pair --> jora OK
		if(text2[j]=='\u062C')
		{
			
		
			tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//CHAY verify it
		///THIEF CHOR
		if(text2[j]=='\u0686')
		{
			
		
			tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		//HAY
		///HAMZA--->OK
		if(text2[j]=='\u062D')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		//KHEH
		//Rabbit-->OK
		if(text2[j]=='\u062E')
		{
			
		
			tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		//DAL
		///river-->driya OK
		if(text2[j]=='\u062F')
		{
			
		
			tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//DDAL
		///DOLPHIN --> OK
		if(text2[j]=='\u0688')
		{
			
		
			tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//ZAL verify it 
		if(text2[j]=='\u0630')
		{
			
		
			tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//REY
		///ROAD-->OK
		if(text2[j]=='\u0631')
		{
			
		
			tts.speak("YER", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//RREY
		
		if(text2[j]=='\u0691')
		{
			
		
			tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//ZAY  verified
		///earthquake-->OK
		if(text2[j]=='\u0632')
		{
			
		
			tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///2SAY verified 
		///SAMAR->OK
		
		if(text2[j]=='\u0698')
		{
			
		
			tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///SEEN
		///Conspiracy-->sazish OK
		if(text2[j]=='\u0633')
		{
			
		
			tts.speak("ES", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///SHEEN
		///Complaint--->shikaiat
		if(text2[j]=='\u0634')
		{
			
		
			tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///SAWAD
		///SOAP-->sabun OK
		if(text2[j]=='\u0635')
		{
			
		
			tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//ZAWAD
		///
		if(text2[j]=='\u0636')
		{
			
		
			tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
			
		}
		///TOHAY
		///TAHIR-->OK
		if(text2[j]=='\u0637')
		{
			
		
			tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///ZOHAY
		///Zafar--->OK
		if(text2[j]=='\u0638')
		{
			
		
			tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//AIN
		/// USMAN---> OK
		if(text2[j]=='\u0639')
		{
			
		
			tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//GAIN
		///GALIB--->OK
		if(text2[j]=='\u063A')
		{
			
		
			tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///FAY
		///FAHAD-->OK
		if(text2[j]=='\u0641')
		{
			
		
			tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///QAF nukhto wala
		///FORT-->QILA OK
		if(text2[j]=='\u0642')
		{
			
		
			tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///KAF Dandy wala
		///BOOOK-->OK
		if(text2[j]=='\u06A9')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///GAF verify it 
		///SONG --->GEET OK
		if(text2[j]=='\u06AF')
		{
			
		
			tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///LAM 
		///laiq-->OK
		if(text2[j]=='\u0644')
		{
			
		
			tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///MEEM
		///OK  complete--->mukamal
		if(text2[j]=='\u0645')
		{
			
		
			tts.speak("im", TextToSpeech.QUEUE_ADD, null);
			//Thread.sleep(100);
			
		}
		
		///NOON
		///Name--->OK
		if(text2[j]=='\u0646')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///NOOON GUNNA
		///Not verified
		if(text2[j]=='\u06BA')
		{
			
		
			tts.speak("Hain", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///WOW
		///THey--->OK
		if(text2[j]=='\u0648')
		{
			
		
			tts.speak("You", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///WOW hamza kay sath
		/// Not verified
		if(text2[j]=='\u0624')
		{
			
		
			tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///HEY
		///Hero--> OK
		if(text2[j]=='\u06C1')
		{
			
		
			tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///ANKHO WALI HAY
		///Not verified
		if(text2[j]=='\u06BE')
		{
			
		
			tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///HAMZA leave because string could not start with hamza
		
		///HAMZA
		
		if(text2[j]=='\u0620')
		{
			
		
			tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		
		///YEH  ya choti yeh
		///Not verified
		
		if(text2[j]=='\u06CC')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///doosra yeh
		
		
		if(text2[j]=='\u064A')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		///barhi yeh
		///Not verified
		if(text2[j]=='\u06D2')
		{
			
		
			tts.speak("HE AY", TextToSpeech.QUEUE_ADD, null);
			
			
		}
		
		
		
		///BARHI YEH WITH HAMZA
		///Nor verified///////////////////////////////////////
		if(text2[j]=='\u06D3')
		{
			
		
			tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
			
			
		}
		if(text2[j]=='\u0020')
		{
			count=count+1;
			m=j;
			//Thread.sleep(100);
			//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
			//Thread.sleep(100);
			
		
		}
		/*
		if(text2[j]=='\u002E')
		{
			count=count+1;
			m=j;
			//Thread.sleep(100);
			//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
			//Thread.sleep(100);
			
		
		}
		*/
		if(jo==count)
		{
			ct=8;
			
			break;
		}
		else
		{
			m=m+1;
		
		}
		
		
		
		}

			
			
			
	
			
			
			
			
			
			
			
		
			
//////////////////////////////ccchotiiiii yeeeee
			if(text2[m]=='\u06CC')
			{
				
				count=count+1;
				j=m+1;
			

				//tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("YA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("EB", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("ut", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("is", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("im", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("You", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("HE AY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
			
			
		/////DOOSRA YEH NUKTO WALA 
		
					
		//////////////////////////////DOOSRA YEH NUKHTO WALA///////////////////
		if(text2[m]=='\u064A')
		{
		
		count=count+1;
		j=m+1;
		
		
		//tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
		///ALIF MADDA
		
		///TODAY-->AJ OK
		
		if(text2[j]=='\u0622')
		{
			
		
			tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///ALIF
		
		/// ASAD-->ok
		if(text2[j]=='\u0627')
		{
			
			
		
			tts.speak("YA", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		
		///BAY 
		///sheep ok
		
		if(text2[j]=='\u0628')
		{
			
		
			tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///PAY
		
		///captured --> PAR OK
		
		if(text2[j]=='\u067E')
		{
			
		
			tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///TAY 
		///Parrot-->totay OK
		if(text2[j]=='\u062A')
		{
			
		
			tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//TTAY
		///TOMATOE--> OK
		if(text2[j]=='\u0679')
		{
			
		
			tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//SAY  VERIFied
		
		///SAMAR->OK
		if(text2[j]=='\u062B')
		{
			
		
			tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		//JEEM
		//Pair --> jora OK
		if(text2[j]=='\u062C')
		{
			
		
			tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//CHAY verify it
		///THIEF CHOR
		if(text2[j]=='\u0686')
		{
			
		
			tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		//HAY
		///HAMZA--->OK
		if(text2[j]=='\u062D')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		//KHEH
		//Rabbit-->OK
		if(text2[j]=='\u062E')
		{
			
		
			tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		//DAL
		///river-->driya OK
		if(text2[j]=='\u062F')
		{
			
		
			tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//DDAL
		///DOLPHIN --> OK
		if(text2[j]=='\u0688')
		{
			
		
			tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//ZAL verify it 
		if(text2[j]=='\u0630')
		{
			
		
			tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//REY
		///ROAD-->OK
		if(text2[j]=='\u0631')
		{
			
		
			tts.speak("YER", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//RREY
		
		if(text2[j]=='\u0691')
		{
			
		
			tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//ZAY  verified
		///earthquake-->OK
		if(text2[j]=='\u0632')
		{
			
		
			tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///2SAY verified 
		///SAMAR->OK
		
		if(text2[j]=='\u0698')
		{
			
		
			tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///SEEN
		///Conspiracy-->sazish OK
		if(text2[j]=='\u0633')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///SHEEN
		///Complaint--->shikaiat
		if(text2[j]=='\u0634')
		{
			
		
			tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///SAWAD
		///SOAP-->sabun OK
		if(text2[j]=='\u0635')
		{
			
		
			tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//ZAWAD
		///
		if(text2[j]=='\u0636')
		{
			
		
			tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
			
		}
		///TOHAY
		///TAHIR-->OK
		if(text2[j]=='\u0637')
		{
			
		
			tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///ZOHAY
		///Zafar--->OK
		if(text2[j]=='\u0638')
		{
			
		
			tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//AIN
		/// USMAN---> OK
		if(text2[j]=='\u0639')
		{
			
		
			tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		//GAIN
		///GALIB--->OK
		if(text2[j]=='\u063A')
		{
			
		
			tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///FAY
		///FAHAD-->OK
		if(text2[j]=='\u0641')
		{
			
		
			tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///QAF nukhto wala
		///FORT-->QILA OK
		if(text2[j]=='\u0642')
		{
			
		
			tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///KAF Dandy wala
		///BOOOK-->OK
		if(text2[j]=='\u06A9')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///GAF verify it 
		///SONG --->GEET OK
		if(text2[j]=='\u06AF')
		{
			
		
			tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///LAM 
		///laiq-->OK
		if(text2[j]=='\u0644')
		{
			
		
			tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///MEEM
		///OK  complete--->mukamal
		if(text2[j]=='\u0645')
		{
			
		
			tts.speak("im", TextToSpeech.QUEUE_ADD, null);
			//Thread.sleep(100);
			
		}
		
		///NOON
		///Name--->OK
		if(text2[j]=='\u0646')
		{
			
		
			tts.speak("", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///NOOON GUNNA
		///Not verified
		if(text2[j]=='\u06BA')
		{
			
		
			tts.speak("Hain", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///WOW
		///THey--->OK
		if(text2[j]=='\u0648')
		{
			
		
			tts.speak("You", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///WOW hamza kay sath
		/// Not verified
		if(text2[j]=='\u0624')
		{
			
		
			tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///HEY
		///Hero--> OK
		if(text2[j]=='\u06C1')
		{
			
		
			tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///ANKHO WALI HAY
		///Not verified
		if(text2[j]=='\u06BE')
		{
			
		
			tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		///HAMZA leave because string could not start with hamza
		
		///HAMZA
		
		if(text2[j]=='\u0620')
		{
			
		
			tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		
		///YEH  ya choti yeh
		///Not verified
		
		if(text2[j]=='\u06CC')
		{
			
		
			tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		///doosra yeh
		
		
		if(text2[j]=='\u064A')
		{
			
		
			tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
			
		}
		
		
		
		///barhi yeh
		///Not verified
		if(text2[j]=='\u06D2')
		{
			
		
			tts.speak("HE AY", TextToSpeech.QUEUE_ADD, null);
			
			
		}
		
		
		
		///BARHI YEH WITH HAMZA
		///Nor verified///////////////////////////////////////
		if(text2[j]=='\u06D3')
		{
			
		
			tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
			
			
		}
		if(text2[j]=='\u0020')
		{
			count=count+1;
			m=j;
			//Thread.sleep(100);
			//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
			//Thread.sleep(100);
			
		
		}
		/*
		if(text2[j]=='\u002E')
		{
			count=count+1;
			m=j;
			//Thread.sleep(100);
			//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
			//Thread.sleep(100);
			
		
		}
		*/
		if(jo==count)
		{
			ct=8;
			
			break;
		}
		else
		{
			m=m+1;
		
		}
		
		
		
		}
			
			
		
			
/////////////////////bbbbbbbbbbbbaaaaaaaaaaaarrrrrrrrrrrrrriiiiiiiiiyyyyyyyyy
			if(text2[m]=='\u06D2')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOHEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				*/
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			
	//////////////////////bbbbbaaaarrreeeyyy withhhh hamzaaaa
			
			if(text2[m]=='\u06D3')
			{
				
				count=count+1;
				j=m+1;
			
				
				///ALIF MADDA
				
				///TODAY-->AJ OK
				
				if(text2[j]=='\u0622')
				{
					

					tts.speak("ALIF Madda", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ALIF
				
				/// ASAD-->ok
				if(text2[j]=='\u0627')
				{
					
					

					tts.speak("ALIF", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///BAY 
				///sheep ok
				
				if(text2[j]=='\u0628')
				{
					

					tts.speak("BAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///PAY
				
				///captured --> PAR OK
				
				if(text2[j]=='\u067E')
				{
					

					tts.speak("PAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///TAY 
				///Parrot-->totay OK
				if(text2[j]=='\u062A')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//TTAY
				///TOMATOE--> OK
				if(text2[j]=='\u0679')
				{
					

					tts.speak("TAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//SAY  VERIFied
				
				///SAMAR->OK
				if(text2[j]=='\u062B')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//JEEM
				//Pair --> jora OK
				if(text2[j]=='\u062C')
				{
					

					tts.speak("JEEM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//CHAY verify it
				///THIEF CHOR
				if(text2[j]=='\u0686')
				{
					

					tts.speak("CHAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				//HAY
				///HAMZA--->OK
				if(text2[j]=='\u062D')
				{
					

					tts.speak("HAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				//KHEH
				//Rabbit-->OK
				if(text2[j]=='\u062E')
				{
					

					tts.speak("KHEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				//DAL
				///river-->driya OK
				if(text2[j]=='\u062F')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//DDAL
				///DOLPHIN --> OK
				if(text2[j]=='\u0688')
				{
					

					tts.speak("DAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAL verify it 
				if(text2[j]=='\u0630')
				{
					

					tts.speak("ZAL", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//REY
				///ROAD-->OK
				if(text2[j]=='\u0631')
				{
					

					tts.speak("REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//RREY
				
				if(text2[j]=='\u0691')
				{
					

					tts.speak("R REY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAY  verified
				///earthquake-->OK
				if(text2[j]=='\u0632')
				{
					

					tts.speak("ZAY", TextToSpeech.QUEUE_ADD, null);
					
				}

				
				///2SAY verified 
				///SAMAR->OK
				
				if(text2[j]=='\u0698')
				{
					

					tts.speak("SAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///SEEN
				///Conspiracy-->sazish OK
				if(text2[j]=='\u0633')
				{
					

					tts.speak("SEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SHEEN
				///Complaint--->shikaiat
				if(text2[j]=='\u0634')
				{
					

					tts.speak("SHEEN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///SAWAD
				///SOAP-->sabun OK
				if(text2[j]=='\u0635')
				{
					

					tts.speak("SA WAAD", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//ZAWAD
				///
				if(text2[j]=='\u0636')
				{
					

					tts.speak("Za waad", TextToSpeech.QUEUE_ADD, null);
					
				}
				///TOHAY
				///TAHIR-->OK
				if(text2[j]=='\u0637')
				{
					

					tts.speak("TOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///ZOHAY
				///Zafar--->OK
				if(text2[j]=='\u0638')
				{
					

					tts.speak("ZOEIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//AIN
				/// USMAN---> OK
				if(text2[j]=='\u0639')
				{
					

					tts.speak("AIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				//GAIN
				///GALIB--->OK
				if(text2[j]=='\u063A')
				{
					

					tts.speak("GAIN", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///FAY
				///FAHAD-->OK
				if(text2[j]=='\u0641')
				{
					

					tts.speak("FAY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///QAF nukhto wala
				///FORT-->QILA OK
				if(text2[j]=='\u0642')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///KAF Dandy wala
				///BOOOK-->OK
				if(text2[j]=='\u06A9')
				{
					

					tts.speak("Kaaff", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///GAF verify it 
				///SONG --->GEET OK
				if(text2[j]=='\u06AF')
				{
					

					tts.speak("Gaaf", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///LAM 
				///laiq-->OK
				if(text2[j]=='\u0644')
				{
					

					tts.speak("LAM", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///MEEM
				///OK  complete--->mukamal
				if(text2[j]=='\u0645')
				{
					

					tts.speak("MEEM", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				}
				
				///NOON
				///Name--->OK
				if(text2[j]=='\u0646')
				{
					

					tts.speak("NOON", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///NOOON GUNNA
				///Not verified
				if(text2[j]=='\u06BA')
				{
					

					tts.speak("NOON GUNNA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///WOW
				///THey--->OK
				if(text2[j]=='\u0648')
				{
					

					tts.speak("WOW", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///WOW hamza kay sath
				/// Not verified
				if(text2[j]=='\u0624')
				{
					

					tts.speak("WOW hamza", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HEY
				///Hero--> OK
				if(text2[j]=='\u06C1')
				{
					

					tts.speak("HEY", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///ANKHO WALI HAY
				///Not verified
				if(text2[j]=='\u06BE')
				{
					

					tts.speak("HEY Ankho", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				///HAMZA leave because string could not start with hamza
				
				///HAMZA
				
				if(text2[j]=='\u0620')
				{
					

					tts.speak("HAMZA", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				
				
				
				///YEH  ya choti yeh
				///Not verified
				
				if(text2[j]=='\u06CC')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
				
				///doosra yeh
				
			
				if(text2[j]=='\u064A')
				{
					

					tts.speak("YEH", TextToSpeech.QUEUE_ADD, null);
					
				}
			
				
				
				///barhi yeh
				///Not verified
				if(text2[j]=='\u06D2')
				{
					

					tts.speak("BARY YEY", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				
				
				
				///BARHI YEH WITH HAMZA
				///Nor verified///////////////////////////////////////
				if(text2[j]=='\u06D3')
				{
					

					tts.speak("BARY YEY hamza ", TextToSpeech.QUEUE_ADD, null);
					
					
				}
				if(text2[j]=='\u0020')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}
				/*
				if(text2[j]=='\u002E')
				{
					count=count+1;
					m=j;
					//Thread.sleep(100);
					//tts.speak("Space ", TextToSpeech.QUEUE_ADD, null);
					//Thread.sleep(100);
					
				
				}*/
				
				if(jo==count)
				{
					ct=8;
					
					break;
				}
				else
				{
					m=m+1;
				
				}
				

			
			}
			
			/*
			if(text2[m]!='\u0627'&&text2[m]!='\u0622'&&text2[m]!='\u0628'&&text2[m]!='\u067E'&&text2[m]!='\u062A'&&text2[m]!='\u0679'&&text2[m]!='\u062B'&&text2[m]!='\u062C'&&text2[m]!='\u0686'&&text2[m]!='\u062D'&&text2[m]!='\u062E'&&text2[m]!='\u062F'&&text2[m]!='\u0688'&&text2[m]!='\u0630'&&text2[m]!='\u0631'&&text2[m]!='\u0691'&&text2[m]!='\u0632'&&
					
					text2[m]!='\u0698'&&text2[m]!='\u0633'&&text2[m]!='\u0634'&&text2[m]!='\u0635'&&text2[m]!='\u0636'&&text2[m]!='\u0637'&&text2[m]!='\u0638'&&text2[m]!='\u0639'&&text2[m]!='\u063A'&&text2[m]!='\u0641'&&text2[m]!='\u0642'&&text2[m]!='\u06A9'&&text2[m]!='\u06AF'&&text2[m]!='\u0644'&&text2[m]!='\u0645'&&text2[m]!='\u0646'&&text2[m]!='\u06BA'
					
					&&text2[m]!='\u0648'&&text2[m]!='\u0624'&&text2[m]!='\u06C1'&&text2[m]!='\u06BE'&&text2[m]!='\u0620'&&text2[m]!='\u06CC'&&text2[m]!='\u064A'&&text2[m]!='\u06D2'&&text2[m]!='\u06D3'&&text2[m]!='\u0020')
					{
				      
				count=count+1;
				m=j;
				
					if(jo==count)
					{
						ct=8;
						break;
					}
				     
					}
		*/
			
			
			
			
			
			///////////////////////////////////////////////
			i=m;
			j=i+1;
			}
			while(ct<3);
		 
			////////////////////////////////////////////////////
			
		
			
			
	
	}

	@Override
	public void onInit(int status) 
	{
		if (status == TextToSpeech.SUCCESS) 
		{
			int result=tts.setLanguage(Locale.US);

	        if (result == TextToSpeech.LANG_MISSING_DATA
	                || result == TextToSpeech.LANG_NOT_SUPPORTED)
	        {
	            Log.e("TTS", "This Language is not supported");
	        }
	        else 
	        {
	            
	        }

	    }
		else
	    {
	        Log.e("TTS", "Fsilure");
	    }
		
	}

	


}
