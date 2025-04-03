package expo.modules.printers.epson.internals

import com.epson.epos2.printer.Printer

object EpsonModelCapability {

    const val UNKNOWN = Printer.UNKNOWN

    private val modelNameToSeries = mapOf(
        "TM-m10" to Printer.TM_M10,
        "TM-m30" to Printer.TM_M30,
        "TM-m30II" to Printer.TM_M30II,
        "TM-m30II-H" to Printer.TM_M30II,
        "TM-m30II-NT" to Printer.TM_M30II,
        "TM-m30II-S" to Printer.TM_M30II,
        "TM-m30II-SL" to Printer.TM_M30II,
        "TM-m50" to Printer.TM_M50,
        "TM-T20" to Printer.TM_T20,
        "TM-T20II" to Printer.TM_T20,
        "TM-T20III" to Printer.TM_T20,
        "TM-T20IIIL" to Printer.TM_T20,
        "TM-T20X" to Printer.TM_T20,
        "TM-T60" to Printer.TM_T60,
        "TM-T70" to Printer.TM_T70,
        "TM-T70II" to Printer.TM_T70,
        "TM-T81II" to Printer.TM_T81,
        "TM-T81III" to Printer.TM_T81,
        "TM-T82" to Printer.TM_T82,
        "TM-T82II" to Printer.TM_T82,
        "TM-T82III" to Printer.TM_T82,
        "TM-T82IIIL" to Printer.TM_T82,
        "TM-T82X" to Printer.TM_T82,
        "TM-T83II" to Printer.TM_T83,
        "TM-T83III" to Printer.TM_T83III,
        "TM-T88V" to Printer.TM_T88,
        "TM-T88VI" to Printer.TM_T88,
        "TM-T88VII" to Printer.TM_T88VII,
        "TM-T100" to Printer.TM_T100,
        "TM-L90" to Printer.TM_L90,
        "TM-U220" to Printer.TM_U220,
        "TM-U330" to Printer.TM_U330,
        "EU-m30" to Printer.EU_M30,
        "TM-P20" to Printer.TM_P20,
        "TM-P60" to Printer.TM_P60,
        "TM-P60II" to Printer.TM_P60II,
        "TM-P80" to Printer.TM_P80,
        "TM-H6000V" to Printer.TM_H6000,
        "TM-T20II-i" to Printer.TM_T20,
        "TM-T70-i" to Printer.TM_T70,
        "TM-T82II-i" to Printer.TM_T82,
        "TM-T83II-i" to Printer.TM_T83,
        "TM-T88V-i" to Printer.TM_T88,
        "TM-T88VI-iHUB" to Printer.TM_T88,
        "TM-U220-i" to Printer.TM_U220,
        "TM-T70II-DT" to Printer.TM_T70,
        "TM-T70II-DT2" to Printer.TM_T70,
        "TM-T88V-DT" to Printer.TM_T88,
        "TM-T88VI-DT2" to Printer.TM_T88,
        "TM-H6000IV-DT" to Printer.TM_H6000,
        "TM-T88IV" to Printer.TM_T88,
        "TM-T90" to Printer.TM_T90,
        "TM-L90" to Printer.TM_L90,
        "TM-H6000IV" to Printer.TM_H6000
    )

    fun getSupportedModels(): List<String> {
        return modelNameToSeries.keys.toList()
    }

    fun printerSeriesByName(providedPrinterName: String): Int {

        val printerNames = modelNameToSeries.keys

        val found = printerNames.firstOrNull { printerName -> printerName == providedPrinterName }
            ?: printerNames.firstOrNull { printerName -> providedPrinterName.contains(printerName) }

        return if (found != null) {
            modelNameToSeries[found]!!
        } else UNKNOWN

    }
}