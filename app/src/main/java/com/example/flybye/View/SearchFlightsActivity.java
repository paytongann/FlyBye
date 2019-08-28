package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;
import com.example.flybye.Model.Results;
import com.example.flybye.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SearchFlightsActivity extends AppCompatActivity {

    private Spinner stateSpinner, airportSpinner;
    private Button  btnArrivalDetails;
    private static final String TAG = "SearchFlightsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flights);

        stateSpinner = findViewById(R.id.spinner_state);
        final ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(
                SearchFlightsActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.states));
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (stateSpinner.getItemAtPosition(i).equals("Alabama")) {
                    setAirport(R.array.alabama_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Alaska")) {
                    setAirport(R.array.alaska_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Arizona")) {
                    setAirport(R.array.arizona_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Arkansas")) {
                    setAirport(R.array.arkansas_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("California")) {
                    setAirport(R.array.california_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Colorado")) {
                    setAirport(R.array.colorado_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Connecticut")) {
                    setAirport(R.array.connecticut_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("District of Columbia")) {
                    setAirport(R.array.district_of_columbia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Florida")) {
                    setAirport(R.array.florida_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Georgia")) {
                    setAirport(R.array.georgia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Hawaii")) {
                    setAirport(R.array.hawaii_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Idaho")) {
                    setAirport(R.array.idaho_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Illinois")) {
                    setAirport(R.array.illinois_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Indiana")) {
                    setAirport(R.array.indiana_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Iowa")) {
                    setAirport(R.array.iowa_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Kansas")) {
                    setAirport(R.array.kansas_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Kentucky")) {
                    setAirport(R.array.kentucky_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Louisiana")) {
                    setAirport(R.array.louisiana_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Maine")) {
                    setAirport(R.array.maine_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Maryland")) {
                    setAirport(R.array.maryland_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Massachusetts")) {
                    setAirport(R.array.massachusetts_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Michigan")) {
                    setAirport(R.array.michigan_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Minnesota")) {
                    setAirport(R.array.minnesota_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Mississippi")) {
                    setAirport(R.array.mississippi_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Missouri")) {
                    setAirport(R.array.missouri_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Montana")) {
                    setAirport(R.array.montana_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Nebraska")) {
                    setAirport(R.array.nebraska_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Nevada")) {
                    setAirport(R.array.nevada_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New Hampshire")) {
                    setAirport(R.array.new_hampshire_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New Jersey")) {
                    setAirport(R.array.new_jersey_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New Mexico")) {
                    setAirport(R.array.new_mexico_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New York")) {
                    setAirport(R.array.new_york_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("North Carolina")) {
                    setAirport(R.array.north_carolina_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("North Dakota")) {
                    setAirport(R.array.north_dakota_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Ohio")) {
                    setAirport(R.array.ohio_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Oklahoma")) {
                    setAirport(R.array.oklahoma_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Oregon")) {
                    setAirport(R.array.oregon_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Pennsylvania")) {
                    setAirport(R.array.pennsylvania_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Rhode Island")) {
                    setAirport(R.array.rhode_island_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("South Dakota")) {
                    setAirport(R.array.south_dakota_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Tennessee")) {
                    setAirport(R.array.tennessee_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Texas")) {
                    setAirport(R.array.texas_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Utah")){
                    setAirport(R.array.utah_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Vermont")) {
                    setAirport(R.array.vermont_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Virginia")) {
                    setAirport(R.array.virginia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Washington")) {
                    setAirport(R.array.washington_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("West Virginia")) {
                    setAirport(R.array.west_virginia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Wisconsin")) {
                    setAirport(R.array.wisconsin_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Wyoming")) {
                    setAirport(R.array.wyoming_airports);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnArrivalDetails = findViewById(R.id.btn_arrival_details);
        btnArrivalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String way = getIntent().getStringExtra("way");
                if (stateSpinner.getSelectedItem().toString().equals("Select State")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Departure State", Toast.LENGTH_SHORT).show();
                } else if (airportSpinner.getSelectedItem().toString().equals("Select Airport")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Departure Airport", Toast.LENGTH_SHORT).show();
                } else {
                DatePicker departureDatePicker = findViewById(R.id.departure_datepicker);
                int day = departureDatePicker.getDayOfMonth();
                int month = (departureDatePicker.getMonth() + 1);
                int year = departureDatePicker.getYear();
                String monthS = month + "";
                if (month < 10) {
                    monthS = "0" + month;
                }
                String dayS = day + "";
                if (day < 10) {
                    dayS = "0" + day;
                }
                String departureDate = (year + "-" + monthS + "-" + dayS);
                    Intent intent = new Intent(SearchFlightsActivity.this, SearchFlightArrivalActivity.class);
                    intent.putExtra("way", way);
                    intent.putExtra("departureDate", departureDate);
                    intent.putExtra("departureAirport", getAirportIntent());
                    setResult(RESULT_OK, intent);
                    startActivity(intent);
                }
            }
        });
    }

    public void setAirport(int airport) {
        airportSpinner = findViewById(R.id.spinner_airport);
        ArrayAdapter<String> airportAdapter = new ArrayAdapter<String>(
                SearchFlightsActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(airport));
        airportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        airportSpinner.setAdapter(airportAdapter);
    }


    public String getAirportIntent() {
        String departureAirport = "";
        if (airportSpinner.getSelectedItem().toString().equals("Birmingham International Airport")) {
            departureAirport = "BHM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Dothan Regional Airport")) {
            departureAirport = "DHN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Mobile")) {
            departureAirport = "MOB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Huntsville International Airport")) {
            departureAirport = "HSV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Montgomery")) {
            departureAirport = "MGM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Anchorage International Airport")) {
            departureAirport = "ANC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fairbanks International Airport")) {
            departureAirport = "FAI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Juneau International Airport")) {
            departureAirport = "JNU-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Flagstaff")) {
            departureAirport = "FLG-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Phoenix, Phoenix Sky Harbor International Airport")) {
            departureAirport = "PHX-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Tucson International Airport")) {
            departureAirport = "TUS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Yuma International Airport")) {
            departureAirport = "YUM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fayetteville")) {
            departureAirport = "FYV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Little Rock National Airport")) {
            departureAirport = "LIT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Northwest Arkansas Regional Airport")) {
            departureAirport = "XNA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Burbank")) {
            departureAirport = "BUR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fresno")) {
            departureAirport = "FAT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Long Beach")) {
            departureAirport = "LGB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Los Angeles International Airport")) {
            departureAirport = "LAX-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Oakland")) {
            departureAirport = "OAK-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Ontario")) {
            departureAirport = "ONT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Palm Springs")) {
            departureAirport = "PSP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Sacramento")) {
            departureAirport = "SMF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("San Diego")) {
            departureAirport = "SAN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("San Francisco International Airport")) {
            departureAirport = "SFO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("San Jose")) {
            departureAirport = "SJC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Santa Ana")) {
            departureAirport = "SNA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Aspen")) {
            departureAirport = "ASE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Colorado Springs")) {
            departureAirport = "COS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Denver International Airport")) {
            departureAirport = "DEN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Grand Junction")) {
            departureAirport = "GJT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Pueblo")) {
            departureAirport = "PUB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Hartford")) {
            departureAirport = "BDL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Tweed New Haven")) {
            departureAirport = "HVN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Washington, Dulles International Airport")) {
            departureAirport = "IAD-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Washington National Airport")) {
            departureAirport = "DCA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Daytona Beach")) {
            departureAirport = "DAB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fort Lauderdale-Hollywood International Airport")) {
            departureAirport = "FLL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fort Meyers")) {
            departureAirport = "RSW-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Jacksonville")) {
            departureAirport = "JAX-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Key West International Airport")) {
            departureAirport = "EYW-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Miami International Airport")) {
            departureAirport = "MIA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Orlando")) {
            departureAirport = "MCO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Pensacola")) {
            departureAirport = "PNS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("St. Petersburg")) {
            departureAirport = "PIE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Sarasota")) {
            departureAirport = "SRQ-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Tampa")) {
            departureAirport = "TPA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("West Palm Beach")) {
            departureAirport = "PBI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Panama City-Bay County International Airport")) {
            departureAirport = "PFN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Atlanta Hartsfield International Airport")) {
            departureAirport = "ATL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Augusta")) {
            departureAirport = "AGS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Savannah")) {
            departureAirport = "SAV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Hilo")) {
            departureAirport = "ITO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Honolulu International Airport")) {
            departureAirport = "HNL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Kahului")) {
            departureAirport = "OGG-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Kailua")) {
            departureAirport = "KOA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Lihue")) {
            departureAirport = "LIH-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Boise")) {
            departureAirport = "BOI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Chicago Midway Airport")) {
            departureAirport = "MDW-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Chicago OHare International Airport Airport")) {
            departureAirport = "ORD-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Moline")) {
            departureAirport = "MLI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Peoria")) {
            departureAirport = "PIA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Evansville")) {
            departureAirport = "EVV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fort Wayne")) {
            departureAirport = "FWA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Indianapolis International Airport")) {
            departureAirport = "IND-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("South Bend")) {
            departureAirport = "SBN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Cedar Rapids")) {
            departureAirport = "CID-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Des Moines")) {
            departureAirport = "DSM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Wichita")) {
            departureAirport = "ICT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Lexington")) {
            departureAirport = "LEX-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Louisville")) {
            departureAirport = "SDF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Baton Rouge")) {
            departureAirport = "BTR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("New Orleans International Airport")) {
            departureAirport = "MSY-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Shreveport")) {
            departureAirport = "SHV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Augusta")) {
            departureAirport = "AUG-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Bangor")) {
            departureAirport = "BGR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Portland")) {
            departureAirport = "PWM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Baltimore")) {
            departureAirport = "BWI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Boston, Logan International Airport")) {
            departureAirport = "BOS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Hyannis")) {
            departureAirport = "HYA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Nantucket")) {
            departureAirport = "ACK-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Worcester")) {
            departureAirport = "ORH-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Battlecreek")) {
            departureAirport = "BTL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Detroit Metropolitan Airport")) {
            departureAirport = "DTW-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Detroit")) {
            departureAirport = "DET-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Flint")) {
            departureAirport = "FNT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Grand Rapids")) {
            departureAirport = "GRR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Kalamazoo-Battle Creek International Airport")) {
            departureAirport = "AZO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Lansing")) {
            departureAirport = "LAN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Saginaw")) {
            departureAirport = "MBS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Duluth")) {
            departureAirport = "DLH-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Minneapolis/St.Paul International Airport")) {
            departureAirport = "MSP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Rochester")) {
            departureAirport = "RST-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Gulfport")) {
            departureAirport = "GPT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Jackson")) {
            departureAirport = "JAN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Kansas City")) {
            departureAirport = "MCI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("St Louis, Lambert International Airport")) {
            departureAirport = "STL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Springfield")) {
            departureAirport = "SGF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Billings")) {
            departureAirport = "BIL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Lincoln")) {
            departureAirport = "LNK-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Omaha")) {
            departureAirport = "OMA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Las Vegas, Las Vegas McCarran International Airport")) {
            departureAirport = "LAS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Reno-Tahoe International Airport")) {
            departureAirport = "RNO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Manchester")) {
            departureAirport = "MHT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Atlantic City International Airport")) {
            departureAirport = "ACY-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Newark International Airport")) {
            departureAirport = "EWR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Trenton")) {
            departureAirport = "TTN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Albuquerque International Airport")) {
            departureAirport = "ABQ-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Alamogordo")) {
            departureAirport = "ALM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Albany International Airport")) {
            departureAirport = "ALB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Buffalo")) {
            departureAirport = "BUF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Islip")) {
            departureAirport = "ISP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("New York, John F Kennedy International Airport")) {
            departureAirport = "JFK-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("New York, La Guardia Airport")) {
            departureAirport = "LGA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Newburgh")) {
            departureAirport = "SWF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Rochester")) {
            departureAirport = "ROC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Syracuse")) {
            departureAirport = "SYR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Westchester")) {
            departureAirport = "HPN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Asheville")) {
            departureAirport = "AVL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Charlotte/Douglas International Airport")) {
            departureAirport = "CLT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fayetteville")) {
            departureAirport = "FAY-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Greensboro")) {
            departureAirport = "GSO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Raleigh")) {
            departureAirport = "RDU-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Winston-Salem")) {
            departureAirport = "INT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Bismark")) {
            departureAirport = "BIS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Fargo")) {
            departureAirport = "FAR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Akron")) {
            departureAirport = "CAK-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Cincinnati")) {
            departureAirport = "CVG-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Cleveland")) {
            departureAirport = "CLE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Columbus")) {
            departureAirport = "CMH-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Dayton")) {
            departureAirport = "DAY-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Toledo")) {
            departureAirport = "TOL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Oklahoma City")) {
            departureAirport = "OKC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Tulsa")) {
            departureAirport = "TUL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Eugene")) {
            departureAirport = "EUG-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Portland International Airport")) {
            departureAirport = "PDX-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Portland, Hillsboro Airport")) {
            departureAirport = "HIO-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Salem")) {
            departureAirport = "SLE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Allentown")) {
            departureAirport = "ABE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Erie")) {
            departureAirport = "ERI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Harrisburg")) {
            departureAirport = "MDT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Philadelphia")) {
            departureAirport = "PHL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Pittsburgh")) {
            departureAirport = "PIT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Scranton")) {
            departureAirport = "AVP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Providence - T.F. Green Airport")) {
            departureAirport = "PVD-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Charleston")) {
            departureAirport = "CHS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Columbia")) {
            departureAirport = "CAE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Greenville")) {
            departureAirport = "GSP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Myrtle Beach")) {
            departureAirport = "MYR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Pierre")) {
            departureAirport = "PIR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Rapid City")) {
            departureAirport = "RAP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Sioux Falls")) {
            departureAirport = "FSD-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Bristol")) {
            departureAirport = "TRI-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Chattanooga")) {
            departureAirport = "CHA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Knoxville")) {
            departureAirport = "TYS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Memphis")) {
            departureAirport = "MEM-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Nashville")) {
            departureAirport = "BNA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Amarillo")) {
            departureAirport = "AMA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Austin Bergstrom International Airport")) {
            departureAirport = "AUS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Corpus Christi")) {
            departureAirport = "CRP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Dallas Love Field Airport")) {
            departureAirport = "DAL-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Dallas/Fort Worth International Airport")) {
            departureAirport = "DFW-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("El Paso")) {
            departureAirport = "ELP-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Houston, William B Hobby Airport")) {
            departureAirport = "HOU-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Houston, George Bush Intercontinental Airport")) {
            departureAirport = "IAH-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Lubbock")) {
            departureAirport = "LBB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Midland")) {
            departureAirport = "MAF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("San Antonio International Airport")) {
            departureAirport = "SAT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Salt Lake City")) {
            departureAirport = "SLC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Burlington")) {
            departureAirport = "BTV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Montpelier")) {
            departureAirport = "MPV-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Rutland")) {
            departureAirport = "RUT-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Dulles")) {
            departureAirport = "IAD-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Newport News")) {
            departureAirport = "PHF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Norfolk")) {
            departureAirport = "ORF-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Richmond")) {
            departureAirport = "RIC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Roanoke")) {
            departureAirport = "ROA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Pasco, Pasco/Tri-Cities Airport")) {
            departureAirport = "PSC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Seattle, Tacoma International Airport")) {
            departureAirport = "SEA-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Spokane International Airport")) {
            departureAirport = "GEG-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Charleston")) {
            departureAirport = "CRW-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Clarksburg")) {
            departureAirport = "CKB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Huntington Tri-State Airport")) {
            departureAirport = "HTS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Green Bay")) {
            departureAirport = "GRB-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Madison")) {
            departureAirport = "MSN-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Milwaukee")) {
            departureAirport = "MKE-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Casper")) {
            departureAirport = "CPR-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Cheyenne")) {
            departureAirport = "CYS-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Jackson Hole")) {
            departureAirport = "JAC-sky";
        } else if (airportSpinner.getSelectedItem().toString().equals("Rock Springs")) {
            departureAirport = "RKS-sky";
        }
        return departureAirport;
    }
}
