package com.outsystems.plugins.healthfitnesslib.background.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = BackgroundJob.TABLE_NAME,
    primaryKeys = ["variable", "comparison", "value"],
    foreignKeys = [ForeignKey(
        entity = Notification::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("notification_id"),
        onDelete = ForeignKey.CASCADE)]
)
open class BackgroundJob {

    enum class ComparisonOperationEnum(val id : String) {
        GREATER("HIGHER"),
        GREATER_OR_EQUALS("HIGHER_EQUALS"),
        LESSER("LOWER"),
        LESSER_OR_EQUALS("LOWER_EQUALS"),
        EQUALS("EQUALS"),
    }
    @ColumnInfo(name = "variable") var variable: String = ""
    @ColumnInfo(name = "comparison") var comparison: String = ""
    @ColumnInfo(name = "value") var value: Float = 0.0f
    @ColumnInfo(name = "time_unit") var timeUnit: String? = null
    @ColumnInfo(name = "time_unit_grouping") var timeUnitGrouping: Int? = null
    @ColumnInfo(name = "notification_id") var notificationId: Long? = null
    @ColumnInfo(name = "notification_frequency") var notificationFrequency: String = "ALWAYS"
    @ColumnInfo(name = "notification_frequency_grouping") var notificationFrequencyGrouping: Int = 1
    @ColumnInfo(name = "next_notification_timestamp") var nextNotificationTimestamp: Long = 0

    companion object {
        const val TABLE_NAME: String= "backgroundJob"
    }
}