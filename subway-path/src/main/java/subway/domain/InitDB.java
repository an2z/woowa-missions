package subway.domain;

import java.util.Arrays;

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

    private static void initPath() {
        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(GYODAE_STATION),
                        StationRepository.findStation(GANGNAM_STATION),
                        TWO,
                        THREE
                )
        );

        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(GANGNAM_STATION),
                        StationRepository.findStation(YEOKSAM_STATION),
                        TWO,
                        THREE
                )
        );

        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(GYODAE_STATION),
                        StationRepository.findStation(SOUTH_TERMINAL_STATION),
                        THREE,
                        TWO
                )
        );

        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(SOUTH_TERMINAL_STATION),
                        StationRepository.findStation(YANGJAE_STATION),
                        SIX,
                        FIVE
                )
        );

        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(YANGJAE_STATION),
                        StationRepository.findStation(MAEBONG_STATION),
                        ONE,
                        ONE
                )
        );

        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(GANGNAM_STATION),
                        StationRepository.findStation(YANGJAE_STATION),
                        TWO,
                        EIGHT
                )
        );

        PathRepository.addPath(
                new Path(
                        StationRepository.findStation(YANGJAE_STATION),
                        StationRepository.findStation(YANGJAE_CITIZEN_FOREST_STATION),
                        TEN,
                        THREE
                )
        );
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
