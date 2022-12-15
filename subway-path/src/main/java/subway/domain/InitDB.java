package subway.domain;

public class InitDB {
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String SOUTH_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";

    private static final String TWO_LINE = "2호선";
    private static final String THREE_LINE = "3호선";
    private static final String SHINBUNDANG_LINE = "신분당선";

    private InitDB() {
    }

    public static void init() {
        initStation();
        initLine();
    }

    private static void initStation() {
        StationRepository.addStation(new Station(GYODAE_STATION));
        StationRepository.addStation(new Station(GANGNAM_STATION));
        StationRepository.addStation(new Station(YEOKSAM_STATION));
        StationRepository.addStation(new Station(SOUTH_TERMINAL_STATION));
        StationRepository.addStation(new Station(YANGJAE_STATION));
        StationRepository.addStation(new Station(YANGJAE_CITIZEN_FOREST_STATION));
        StationRepository.addStation(new Station(MAEBONG_STATION));
    }

    private static void initLine() {
        LineRepository.addLine(new Line(TWO_LINE));
        LineRepository.addLine(new Line(THREE_LINE));
        LineRepository.addLine(new Line(SHINBUNDANG_LINE));
    }
}
