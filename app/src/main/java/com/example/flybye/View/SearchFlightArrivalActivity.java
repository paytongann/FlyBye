package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.flybye.R;

public class SearchFlightArrivalActivity extends AppCompatActivity {

    Spinner stateSpinnerArrival, airportSpinnerArrival;
    Button btnFindFlights;
    private static final String TAG = "SearchFlightArrivalActi";
    DatePicker departureDatePicker;
    String way;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flight_arrival);
        way = getIntent().getStringExtra("way");
        departureDatePicker = findViewById(R.id.arrival_datepicker);
        if (way.equals("oneway")) {
            departureDatePicker.setVisibility(View.INVISIBLE);
        }
        stateSpinnerArrival = findViewById(R.id.spinner_state_arrival);
        final ArrayAdapter<String> stateAdapterArrival = new ArrayAdapter<String>(
                SearchFlightArrivalActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.states));
        stateAdapterArrival.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinnerArrival.setAdapter(stateAdapterArrival);
        stateSpinnerArrival.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (stateSpinnerArrival.getItemAtPosition(i).equals("Alabama")) {
                    setAirportArrival(R.array.alabama_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Alaska")) {
                    setAirportArrival(R.array.alaska_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Arizona")) {
                    setAirportArrival(R.array.arizona_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Arkansas")) {
                    setAirportArrival(R.array.arkansas_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("California")) {
                    setAirportArrival(R.array.california_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Colorado")) {
                    setAirportArrival(R.array.colorado_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Connecticut")) {
                    setAirportArrival(R.array.connecticut_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("District of Columbia")) {
                    setAirportArrival(R.array.district_of_columbia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Florida")) {
                    setAirportArrival(R.array.florida_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Georgia")) {
                    setAirportArrival(R.array.georgia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Hawaii")) {
                    setAirportArrival(R.array.hawaii_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Idaho")) {
                    setAirportArrival(R.array.idaho_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Illinois")) {
                    setAirportArrival(R.array.illinois_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Indiana")) {
                    setAirportArrival(R.array.indiana_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Iowa")) {
                    setAirportArrival(R.array.iowa_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Kansas")) {
                    setAirportArrival(R.array.kansas_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Kentucky")) {
                    setAirportArrival(R.array.kentucky_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Louisiana")) {
                    setAirportArrival(R.array.louisiana_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Maine")) {
                    setAirportArrival(R.array.maine_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Maryland")) {
                    setAirportArrival(R.array.maryland_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Massachusetts")) {
                    setAirportArrival(R.array.massachusetts_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Michigan")) {
                    setAirportArrival(R.array.michigan_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Minnesota")) {
                    setAirportArrival(R.array.minnesota_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Mississippi")) {
                    setAirportArrival(R.array.mississippi_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Missouri")) {
                    setAirportArrival(R.array.missouri_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Montana")) {
                    setAirportArrival(R.array.montana_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Nebraska")) {
                    setAirportArrival(R.array.nebraska_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Nevada")) {
                    setAirportArrival(R.array.nevada_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New Hampshire")) {
                    setAirportArrival(R.array.new_hampshire_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New Jersey")) {
                    setAirportArrival(R.array.new_jersey_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New Mexico")) {
                    setAirportArrival(R.array.new_mexico_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New York")) {
                    setAirportArrival(R.array.new_york_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("North Carolina")) {
                    setAirportArrival(R.array.north_carolina_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("North Dakota")) {
                    setAirportArrival(R.array.north_dakota_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Ohio")) {
                    setAirportArrival(R.array.ohio_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Oklahoma")) {
                    setAirportArrival(R.array.oklahoma_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Oregon")) {
                    setAirportArrival(R.array.oregon_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Pennsylvania")) {
                    setAirportArrival(R.array.pennsylvania_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Rhode Island")) {
                    setAirportArrival(R.array.rhode_island_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("South Dakota")) {
                    setAirportArrival(R.array.south_dakota_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Tennessee")) {
                    setAirportArrival(R.array.tennessee_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Texas")) {
                    setAirportArrival(R.array.texas_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Utah")) {
                    setAirportArrival(R.array.utah_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Vermont")) {
                    setAirportArrival(R.array.vermont_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Virginia")) {
                    setAirportArrival(R.array.virginia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Washington")) {
                    setAirportArrival(R.array.washington_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("West Virginia")) {
                    setAirportArrival(R.array.west_virginia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Wisconsin")) {
                    setAirportArrival(R.array.wisconsin_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Wyoming")) {
                    setAirportArrival(R.array.wyoming_airports);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnFindFlights = findViewById(R.id.btn_find_flights);
        btnFindFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departureAirport = getIntent().getStringExtra("departureAirport");
                String departureDate = getIntent().getStringExtra("departureDate");
                if (stateSpinnerArrival.getSelectedItem().toString().equals("Select State")) {
                    Toast.makeText(SearchFlightArrivalActivity.this, "Select Arrival State", Toast.LENGTH_SHORT).show();
                } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Select Airport")) {
                    Toast.makeText(SearchFlightArrivalActivity.this, "Select Arrival Airport", Toast.LENGTH_SHORT).show();
                } else {
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
                    String arrivalDate = (year + "-" + monthS + "-" + dayS);
                    Intent intent = new Intent(SearchFlightArrivalActivity.this, ResultsActivity.class);
                    if (way.equals("oneway")) {
                        arrivalDate = "";
                    }
                    intent.putExtra("arrivalDate", arrivalDate);
                    intent.putExtra("arrivalAirport", getAirportArrivalIntent());
                    intent.putExtra("departureDate", departureDate);
                    intent.putExtra("departureAirport", departureAirport);
                    intent.putExtra("way", way);
                    setResult(RESULT_OK, intent);
                    startActivity(intent);
                }
            }
        });
    }

    public void setAirportArrival(int airport) {
        airportSpinnerArrival = findViewById(R.id.spinner_airport_arrival);
        ArrayAdapter<String> airportAdapter = new ArrayAdapter<String>(
                SearchFlightArrivalActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(airport));
        airportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        airportSpinnerArrival.setAdapter(airportAdapter);
    }

    public String getAirportArrivalIntent() {
        String departureAirport = "";
        if (airportSpinnerArrival.getSelectedItem().toString().equals("Birmingham International Airport")) {
            departureAirport = "BHM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Dothan Regional Airport")) {
            departureAirport = "DHN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Mobile")) {
            departureAirport = "MOB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Huntsville International Airport")) {
            departureAirport = "HSV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Montgomery")) {
            departureAirport = "MGM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Anchorage International Airport")) {
            departureAirport = "ANC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fairbanks International Airport")) {
            departureAirport = "FAI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Juneau International Airport")) {
            departureAirport = "JNU-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Flagstaff")) {
            departureAirport = "FLG-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Phoenix, Phoenix Sky Harbor International Airport")) {
            departureAirport = "PHX-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Tucson International Airport")) {
            departureAirport = "TUS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Yuma International Airport")) {
            departureAirport = "YUM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fayetteville")) {
            departureAirport = "FYV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Little Rock National Airport")) {
            departureAirport = "LIT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Northwest Arkansas Regional Airport")) {
            departureAirport = "XNA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Burbank")) {
            departureAirport = "BUR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fresno")) {
            departureAirport = "FAT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Long Beach")) {
            departureAirport = "LGB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Los Angeles International Airport")) {
            departureAirport = "LAX-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Oakland")) {
            departureAirport = "OAK-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Ontario")) {
            departureAirport = "ONT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Palm Springs")) {
            departureAirport = "PSP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Sacramento")) {
            departureAirport = "SMF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("San Diego")) {
            departureAirport = "SAN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("San Francisco International Airport")) {
            departureAirport = "SFO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("San Jose")) {
            departureAirport = "SJC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Santa Ana")) {
            departureAirport = "SNA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Aspen")) {
            departureAirport = "ASE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Colorado Springs")) {
            departureAirport = "COS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Denver International Airport")) {
            departureAirport = "DEN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Grand Junction")) {
            departureAirport = "GJT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Pueblo")) {
            departureAirport = "PUB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Hartford")) {
            departureAirport = "BDL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Tweed New Haven")) {
            departureAirport = "HVN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Washington, Dulles International Airport")) {
            departureAirport = "IAD-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Washington National Airport")) {
            departureAirport = "DCA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Daytona Beach")) {
            departureAirport = "DAB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fort Lauderdale-Hollywood International Airport")) {
            departureAirport = "FLL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fort Meyers")) {
            departureAirport = "RSW-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Jacksonville")) {
            departureAirport = "JAX-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Key West International Airport")) {
            departureAirport = "EYW-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Miami International Airport")) {
            departureAirport = "MIA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Orlando")) {
            departureAirport = "MCO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Pensacola")) {
            departureAirport = "PNS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("St. Petersburg")) {
            departureAirport = "PIE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Sarasota")) {
            departureAirport = "SRQ-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Tampa")) {
            departureAirport = "TPA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("West Palm Beach")) {
            departureAirport = "PBI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Panama City-Bay County International Airport")) {
            departureAirport = "PFN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Atlanta Hartsfield International Airport")) {
            departureAirport = "ATL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Augusta")) {
            departureAirport = "AGS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Savannah")) {
            departureAirport = "SAV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Hilo")) {
            departureAirport = "ITO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Honolulu International Airport")) {
            departureAirport = "HNL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Kahului")) {
            departureAirport = "OGG-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Kailua")) {
            departureAirport = "KOA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Lihue")) {
            departureAirport = "LIH-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Boise")) {
            departureAirport = "BOI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Chicago Midway Airport")) {
            departureAirport = "MDW-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Chicago OHare International Airport Airport")) {
            departureAirport = "ORD-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Moline")) {
            departureAirport = "MLI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Peoria")) {
            departureAirport = "PIA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Evansville")) {
            departureAirport = "EVV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fort Wayne")) {
            departureAirport = "FWA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Indianapolis International Airport")) {
            departureAirport = "IND-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("South Bend")) {
            departureAirport = "SBN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Cedar Rapids")) {
            departureAirport = "CID-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Des Moines")) {
            departureAirport = "DSM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Wichita")) {
            departureAirport = "ICT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Lexington")) {
            departureAirport = "LEX-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Louisville")) {
            departureAirport = "SDF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Baton Rouge")) {
            departureAirport = "BTR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("New Orleans International Airport")) {
            departureAirport = "MSY-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Shreveport")) {
            departureAirport = "SHV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Augusta")) {
            departureAirport = "AUG-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Bangor")) {
            departureAirport = "BGR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Portland")) {
            departureAirport = "PWM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Baltimore")) {
            departureAirport = "BWI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Boston, Logan International Airport")) {
            departureAirport = "BOS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Hyannis")) {
            departureAirport = "HYA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Nantucket")) {
            departureAirport = "ACK-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Worcester")) {
            departureAirport = "ORH-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Battlecreek")) {
            departureAirport = "BTL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Detroit Metropolitan Airport")) {
            departureAirport = "DTW-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Detroit")) {
            departureAirport = "DET-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Flint")) {
            departureAirport = "FNT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Grand Rapids")) {
            departureAirport = "GRR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Kalamazoo-Battle Creek International Airport")) {
            departureAirport = "AZO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Lansing")) {
            departureAirport = "LAN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Saginaw")) {
            departureAirport = "MBS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Duluth")) {
            departureAirport = "DLH-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Minneapolis/St.Paul International Airport")) {
            departureAirport = "MSP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Rochester")) {
            departureAirport = "RST-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Gulfport")) {
            departureAirport = "GPT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Jackson")) {
            departureAirport = "JAN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Kansas City")) {
            departureAirport = "MCI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("St Louis, Lambert International Airport")) {
            departureAirport = "STL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Springfield")) {
            departureAirport = "SGF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Billings")) {
            departureAirport = "BIL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Lincoln")) {
            departureAirport = "LNK-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Omaha")) {
            departureAirport = "OMA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Las Vegas, Las Vegas McCarran International Airport")) {
            departureAirport = "LAS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Reno-Tahoe International Airport")) {
            departureAirport = "RNO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Manchester")) {
            departureAirport = "MHT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Atlantic City International Airport")) {
            departureAirport = "ACY-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Newark International Airport")) {
            departureAirport = "EWR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Trenton")) {
            departureAirport = "TTN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Albuquerque International Airport")) {
            departureAirport = "ABQ-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Alamogordo")) {
            departureAirport = "ALM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Albany International Airport")) {
            departureAirport = "ALB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Buffalo")) {
            departureAirport = "BUF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Islip")) {
            departureAirport = "ISP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("New York, John F Kennedy International Airport")) {
            departureAirport = "JFK-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("New York, La Guardia Airport")) {
            departureAirport = "LGA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Newburgh")) {
            departureAirport = "SWF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Rochester")) {
            departureAirport = "ROC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Syracuse")) {
            departureAirport = "SYR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Westchester")) {
            departureAirport = "HPN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Asheville")) {
            departureAirport = "AVL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Charlotte/Douglas International Airport")) {
            departureAirport = "CLT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fayetteville")) {
            departureAirport = "FAY-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Greensboro")) {
            departureAirport = "GSO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Raleigh")) {
            departureAirport = "RDU-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Winston-Salem")) {
            departureAirport = "INT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Bismark")) {
            departureAirport = "BIS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Fargo")) {
            departureAirport = "FAR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Akron")) {
            departureAirport = "CAK-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Cincinnati")) {
            departureAirport = "CVG-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Cleveland")) {
            departureAirport = "CLE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Columbus")) {
            departureAirport = "CMH-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Dayton")) {
            departureAirport = "DAY-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Toledo")) {
            departureAirport = "TOL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Oklahoma City")) {
            departureAirport = "OKC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Tulsa")) {
            departureAirport = "TUL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Eugene")) {
            departureAirport = "EUG-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Portland International Airport")) {
            departureAirport = "PDX-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Portland, Hillsboro Airport")) {
            departureAirport = "HIO-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Salem")) {
            departureAirport = "SLE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Allentown")) {
            departureAirport = "ABE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Erie")) {
            departureAirport = "ERI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Harrisburg")) {
            departureAirport = "MDT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Philadelphia")) {
            departureAirport = "PHL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Pittsburgh")) {
            departureAirport = "PIT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Scranton")) {
            departureAirport = "AVP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Providence - T.F. Green Airport")) {
            departureAirport = "PVD-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Charleston")) {
            departureAirport = "CHS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Columbia")) {
            departureAirport = "CAE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Greenville")) {
            departureAirport = "GSP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Myrtle Beach")) {
            departureAirport = "MYR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Pierre")) {
            departureAirport = "PIR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Rapid City")) {
            departureAirport = "RAP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Sioux Falls")) {
            departureAirport = "FSD-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Bristol")) {
            departureAirport = "TRI-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Chattanooga")) {
            departureAirport = "CHA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Knoxville")) {
            departureAirport = "TYS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Memphis")) {
            departureAirport = "MEM-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Nashville")) {
            departureAirport = "BNA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Amarillo")) {
            departureAirport = "AMA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Austin Bergstrom International Airport")) {
            departureAirport = "AUS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Corpus Christi")) {
            departureAirport = "CRP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Dallas Love Field Airport")) {
            departureAirport = "DAL-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Dallas/Fort Worth International Airport")) {
            departureAirport = "DFW-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("El Paso")) {
            departureAirport = "ELP-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Houston, William B Hobby Airport")) {
            departureAirport = "HOU-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Houston, George Bush Intercontinental Airport")) {
            departureAirport = "IAH-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Lubbock")) {
            departureAirport = "LBB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Midland")) {
            departureAirport = "MAF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("San Antonio International Airport")) {
            departureAirport = "SAT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Salt Lake City")) {
            departureAirport = "SLC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Burlington")) {
            departureAirport = "BTV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Montpelier")) {
            departureAirport = "MPV-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Rutland")) {
            departureAirport = "RUT-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Dulles")) {
            departureAirport = "IAD-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Newport News")) {
            departureAirport = "PHF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Norfolk")) {
            departureAirport = "ORF-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Richmond")) {
            departureAirport = "RIC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Roanoke")) {
            departureAirport = "ROA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Pasco, Pasco/Tri-Cities Airport")) {
            departureAirport = "PSC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Seattle, Tacoma International Airport")) {
            departureAirport = "SEA-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Spokane International Airport")) {
            departureAirport = "GEG-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Charleston")) {
            departureAirport = "CRW-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Clarksburg")) {
            departureAirport = "CKB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Huntington Tri-State Airport")) {
            departureAirport = "HTS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Green Bay")) {
            departureAirport = "GRB-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Madison")) {
            departureAirport = "MSN-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Milwaukee")) {
            departureAirport = "MKE-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Casper")) {
            departureAirport = "CPR-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Cheyenne")) {
            departureAirport = "CYS-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Jackson Hole")) {
            departureAirport = "JAC-sky";
        } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Rock Springs")) {
            departureAirport = "RKS-sky";
        }
        return departureAirport;
    }

}
