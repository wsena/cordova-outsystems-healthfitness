package com.outsystems.plugins.healthfitnesslib.background.database

interface DatabaseManagerInterface {
    fun insert(backgroundJob: BackgroundJob) : Long?
    fun insert(notification: Notification) : Long?
    fun fetchNotifications() : List<Notification>?
    fun fetchBackgroundJobs(variable : String) : List<BackgroundJob>?
    fun fetchBackgroundJob(variable: String, comparison: String, value: Float) : BackgroundJob?
    fun fetchBackgroundJobCountForVariable(variable: String) : Int
    fun fetchNotification(id : Long) : Notification?
    fun deleteBackgroundJob(backgroundJob: BackgroundJob)
    fun updateBackgroundJob(backgroundJob: BackgroundJob)
    fun runInTransaction(closude : () -> Unit)
}