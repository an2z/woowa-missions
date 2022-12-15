package subway.domain;

import java.util.Arrays;
import java.util.List;

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

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int EIGHT = 8;
    private static final int TEN = 10;

    private InitDB() {
    }

    public static void init() {
        initStation();
        initLine();
        initPath();
        initSubway();
    }

    private static void initStation() {
        List<String> names = Arrays.asList(
                GYODAE_STATION, GANGNAM_STATION, YEOKSAM_STATION, SOUTH_TERMINAL_STATION,
                YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION, MAEBONG_STATION
        );

        for (String name : names) {
            StationRepository.addStation(new Station(name));
        }
    }

    private static void initLine() {
        List<String> names = Arrays.asList(TWO_LINE, THREE_LINE, SHINBUNDANG_LINE);

        for (String name : names) {
            LineRepository.addLine(new Line(name));
        }
    }

    private static void initPath() {
        List<List<Object>> paths = Arrays.asList(
                Arrays.asList(findStation(GYODAE_STATION), findStation(GANGNAM_STATION), TWO, THREE),
                Arrays.asList(findStation(GANGNAM_STATION), findStation(YEOKSAM_STATION), TWO, THREE),
                Arrays.asList(findStation(GYODAE_STATION), findStation(SOUTH_TERMINAL_STATION), THREE, TWO),
                Arrays.asList(findStation(SOUTH_TERMINAL_STATION), findStation(YANGJAE_STATION), SIX, FIVE),
                Arrays.asList(findStation(YANGJAE_STATION), findStation(MAEBONG_STATION), ONE, ONE),
                Arrays.asList(findStation(GANGNAM_STATION), findStation(YANGJAE_STATION), TWO, EIGHT),
                Arrays.asList(findStation(YANGJAE_STATION), findStation(YANGJAE_CITIZEN_FOREST_STATION), TEN, THREE)
        );

        for (List<Object> path : paths) {
            PathRepository.addPath(
                    new Path((Station) path.get(0), (Station) path.get(1), (int) path.get(2), (int) path.get(3))
            );
        }
    }

    private static void initSubway() {
        SubwayRepository.addSubway(
                LineRepository.findLine(TWO_LINE),
                Arrays.asList(
                        StationRepository.findStation(GYODAE_STATION),
                        StationRepository.findStation(GANGNAM_STATION),
                        StationRepository.findStation(YEOKSAM_STATION)
                )
        );

        SubwayRepository.addSubway(
                LineRepository.findLine(THREE_LINE),
                Arrays.asList(
                        StationRepository.findStation(GYODAE_STATION),
                        StationRepository.findStation(SOUTH_TERMINAL_STATION),
                        StationRepository.findStation(YANGJAE_STATION),
                        StationRepository.findStation(MAEBONG_STATION)
                )
        );

        SubwayRepository.addSubway(
                LineRepository.findLine(SHINBUNDANG_LINE),
                Arrays.asList(
                        StationRepository.findStation(GANGNAM_STATION),
                        StationRepository.findStation(YANGJAE_STATION),
                        StationRepository.findStation(YANGJAE_CITIZEN_FOREST_STATION)
                )
        );
    }
}
