<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Job extends Model
{
    //public $timestamps=false;
    protected $fillable=[
        'task_name',
        'location',
        'payment',
        'description',
        'work_hours',
    ];
}
