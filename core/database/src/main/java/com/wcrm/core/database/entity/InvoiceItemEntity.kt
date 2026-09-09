package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * موجودیت هر ردیف فاکتور در پایگاه‌داده.
 *
 * اقلام فاکتور جدا از سربرگ ذخیره می‌شوند تا گزارش‌گیری، ویرایش اقلام و توسعه آینده
 * بدون ذخیره‌سازی رشته‌ای یا Converterهای شکننده انجام شود.
 */
@Entity(
    tableName = "invoice_items",
    foreignKeys = [
        ForeignKey(
            entity = InvoiceEntity::class,
            parentColumns = ["id"],
            childColumns = ["invoiceId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("invoiceId")]
)
data class InvoiceItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val invoiceId: Long,
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val unitPrice: Long,
    val discountAmount: Long = 0,
    val taxAmount: Long = 0
)
