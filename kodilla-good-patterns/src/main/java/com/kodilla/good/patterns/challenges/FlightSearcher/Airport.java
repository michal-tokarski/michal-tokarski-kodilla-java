package com.kodilla.good.patterns.challenges.FlightSearcher;

    public enum Airport {
        WAW("Warszawa"),
        GDN("Gdańsk"),
        KRK("Kraków"),
        KAT("Katowice"),
        WRO("Wrocław"),
        BER("Berlin"),
        LON("London"),
        MOS("Moscow"),
        PAR("Paris"),
        MAD("Madrid"),
        ;

        private String name;

        Airport(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
