<?php

namespace App\Http\Controllers;

use App\Job;
use Illuminate\Http\Request;

class JobServices extends Controller
{
    
    public function jobSave(Request $request){
        $job=Job::create($request->all());
        return response()->json($job,201);
    }
}
