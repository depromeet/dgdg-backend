package com.depromeet.dgdg.domain.domain.memo

import com.depromeet.dgdg.domain.domain.BaseTimeEntity
import com.depromeet.dgdg.domain.domain.common.Uuid
import javax.persistence.*

@Entity
class Memo(
    @Column(nullable = false)
    val userId: Long,

    @Enumerated(EnumType.STRING)
    var condition: ConditionType,

    @Enumerated(EnumType.STRING)
    var intensity: IntensityType
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(nullable = false)
    @Embedded
    val uuid: Uuid = Uuid.newInstance()

}
