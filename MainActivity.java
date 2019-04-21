package com.gilo.TrnaslatorWithUrduSpeech;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.gilo.TranslatorWithUrduSpeech.R;

public class MainActivity extends Activity
{
	
	
   // TextView r,r1;
  //  ImageView iv;
  
  //creates a ViewSwitcher object, to switch between Views  
    private ViewSwitcher viewSwitcher;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
   
        
        new LoadViewTaskkk().execute();  
    }  
  
    
    private class LoadViewTaskkk extends AsyncTask<Void,Integer, Void>
    {   
        private TextView tv;  
        private ProgressBar pb_progressBar;  
  
        @Override  
        protected void onPreExecute()  
        {  
            //Initialize the ViewSwitcher object  
            viewSwitcher = new ViewSwitcher(MainActivity.this);  
           
            viewSwitcher.addView(ViewSwitcher.inflate(MainActivity.this, R.layout.activity_main, null));  
  
             
            tv = (TextView) viewSwitcher.findViewById(R.id.textView3);  
            pb_progressBar = (ProgressBar) viewSwitcher.findViewById(R.id.progressBar1);  
            
            pb_progressBar.setMax(100);  
  
            //Set ViewSwitcher instance as the current View.  
            setContentView(viewSwitcher);  
        }  
  
        //Background Code         
        protected Void doInBackground(Void... params)  
        {  
        	
           
        	
            try  
            {  
            	
                synchronized (this)  
                {   
                    int counter = 0;   
                    while(counter <= 4)  
                    {  
                        this.wait(1500);  
                        //Increment the counter  
                        counter++;  
                        
                        publishProgress(counter*20);  
                        
                        
                    }  
                }   
            }  
            catch (InterruptedException e)  
            {  
                e.printStackTrace();  
            }  
        	    return null;  
        }  
        
        
        protected void onProgressUpdate(Integer... values)  
        {  
        	
            
            if(values[0] <= 100)  
            {  
                tv.setText("Progress: " + Integer.toString(values[0]) + "%");  
                pb_progressBar.setProgress(values[0]);  

            
        	}
        }  
              
        protected void onPostExecute(Void result)  
        {  
            
            Toast.makeText(getApplicationContext(), "Loading Completed Successfully", Toast.LENGTH_LONG).show();

         
              
           
		    Intent intent = new Intent(getApplicationContext(), TranslatorWithUrduSpeech.class);
            startActivity(intent);
        	
          //  viewSwitcher.showNext(); 
        }
        
        

	

		

    }  
  
 
}  