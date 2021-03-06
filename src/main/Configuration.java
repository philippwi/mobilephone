package main;

import java.io.FileInputStream;
import java.util.Properties;

public enum Configuration {
    instance;

    public BandType engineType = BandType.SingleBand;
    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String pathToJar = userDirectory + fileSeparator + getBandType() + fileSeparator + "Band.jar";

    public BandType getBandType() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(userDirectory + fileSeparator + "band.props");
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("bandType").equals("SingleBand"))
                return BandType.SingleBand;
            else if (properties.getProperty("bandType").equals("DualBand"))
                return BandType.DualBand;

            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}